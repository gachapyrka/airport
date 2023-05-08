package com.example.airport.controllers;

import com.example.airport.domain.BoughtTicket;
import com.example.airport.domain.ClientInfo;
import com.example.airport.domain.Raise;
import com.example.airport.domain.Ticket;
import com.example.airport.repos.BoughtTicketRepo;
import com.example.airport.repos.RaiseRepo;
import com.example.airport.repos.TicketRepo;
import com.example.airport.services.MailService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/statistics")
@PreAuthorize("hasAuthority('ADMIN')")
public class StatisticsController {
    private final TicketRepo ticketRepo;
    private final BoughtTicketRepo boughtTicketRepo;
    private final RaiseRepo raiseRepo;
    private final MailService mailService;

    public StatisticsController(TicketRepo ticketRepo, BoughtTicketRepo boughtTicketRepo,
                                RaiseRepo raiseRepo, MailService mailService) {
        this.ticketRepo = ticketRepo;
        this.boughtTicketRepo = boughtTicketRepo;
        this.raiseRepo = raiseRepo;
        this.mailService = mailService;
    }

    private List<Raise> getStatisticsRaises(){
        List<Raise> raises = raiseRepo.findByCountOfDays(0);
        for(int i=0; i<raises.size(); i++){
            raises.get(i).setCountOfDays(0);
        }

        for(Ticket t: ticketRepo.findAll()){
            if(t.getBoughtTicket()!=null){
                for(Raise r: raises){
                    if(r.getId()==t.getRaise().getId()){
                        r.setCountOfDays(t.getCount());
                    }
                }
            }
        }
        raises.sort(new Comparator<Raise>() {
            @Override
            public int compare(Raise o1, Raise o2) {
                return o1.getCountOfDays() > o2.getCountOfDays()? 1 : o1.getCountOfDays()==o2.getCountOfDays()? 0: -1;
            }
        });
        return raises;
    }

    private List<Raise> getStatisticsTours(){
        List<Raise> raises = raiseRepo.findByCountOfDaysGreaterThan(0);
        for(int i=0; i<raises.size(); i++){
            raises.get(i).setCountOfDays(0);
        }

        for(Ticket t: ticketRepo.findAll()){
            if(t.getBoughtTicket()!=null){
                for(Raise r: raises){
                    if(r.getId()==t.getRaise().getId()){
                        r.setCountOfDays(t.getCount());
                    }
                }
            }
        }
        raises.sort(new Comparator<Raise>() {
            @Override
            public int compare(Raise o1, Raise o2) {
                return o1.getCountOfDays() > o2.getCountOfDays()? 1 : o1.getCountOfDays()==o2.getCountOfDays()? 0: -1;
            }
        });
        return raises;
    }

    @GetMapping
    public String getStatistics(@RequestParam(required = false, defaultValue = "") String message,Model model){

        model.addAttribute("tours", getStatisticsTours());
        model.addAttribute("raises", getStatisticsRaises());
        if(message!=null && !message.isEmpty())
            model.addAttribute("message", message);
        return "statistics";
    }

    @PostMapping("/send")
    public String sendBoughtTicket(@AuthenticationPrincipal ClientInfo user, Model model){
        String content = "Рейтинг стран по перелетам:\n\n";
        int i=1;
        for(Raise r: getStatisticsRaises()){
            content += i + ". " + r.getTo().getName() + ": " + r.getCountOfDays() + "\n";
            i++;
        }
        content+="\n\n\n";
        content += "Рейтинг стран по турам:\n\n";
        i=1;
        for(Raise r: getStatisticsTours()){
            content += i + ". " + r.getTo().getName() + ": " + r.getCountOfDays() + "\n";
            i++;
        }
        try {
            mailService.send("Статистика", content, user.getUsername(), null);
            return "redirect:/statistics?message=Message sended to email " + user.getUsername() +"";
        } catch (Exception e) {
            e.getMessage();
            return "redirect:/statistics?message=Error: unreached email address " + user.getUsername() +"";
        }
    }
}
