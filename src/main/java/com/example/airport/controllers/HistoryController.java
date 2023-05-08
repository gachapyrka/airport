package com.example.airport.controllers;

import com.example.airport.domain.BoughtTicket;
import com.example.airport.domain.ClientInfo;
import com.example.airport.domain.Ticket;
import com.example.airport.repos.BoughtTicketRepo;
import com.example.airport.repos.TicketRepo;
import com.example.airport.services.MailService;
import com.example.airport.services.PdfService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryController {

    private final PdfService pdfService;
    private final MailService mailService;

    private final TicketRepo ticketRepo;
    private final BoughtTicketRepo boughtTicketRepo;

    public HistoryController(PdfService pdfService, MailService mailService, TicketRepo ticketRepo, BoughtTicketRepo boughtTicketRepo) {
        this.pdfService = pdfService;
        this.mailService = mailService;
        this.ticketRepo = ticketRepo;
        this.boughtTicketRepo = boughtTicketRepo;
    }
    @GetMapping
    public String getHistory(@RequestParam(defaultValue = "", required = false) String message, @AuthenticationPrincipal ClientInfo user, Model model){
        List<BoughtTicket> boughtTickets = new ArrayList<>();
        for(Ticket t: ticketRepo.findAllByClientInfo_Id(user.getId())){
            if(t.getBoughtTicket()!=null){
                boughtTickets.add(t.getBoughtTicket());
            }
        }
        if(message!=null &&!message.isEmpty())
            model.addAttribute("message", message);
        model.addAttribute("tickets", boughtTickets);
        return "history";
    }

    @GetMapping("/{ticket}")
    public String getBoughtTicket(@PathVariable BoughtTicket ticket, Model model){
        List<BoughtTicket> boughtTickets = new ArrayList<>();
        boughtTickets.add(ticket);
        model.addAttribute("tickets", boughtTickets);
        return "boughtTicket";
    }

    @PostMapping("/send/{ticket}")
    public String sendBoughtTicket(@PathVariable BoughtTicket ticket, @AuthenticationPrincipal ClientInfo user, Model model){
        try {
            mailService.send("Билет №" +ticket.getId(), pdfService.createContent(ticket), user.getUsername(), null);
            return "redirect:/history?message=Message sended to email " + user.getUsername() +"";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/download/{ticket}")
    public String downloadBoughtTicket(@PathVariable BoughtTicket ticket, @AuthenticationPrincipal ClientInfo user, Model model){
        try {
            mailService.send("Билет №" +ticket.getId(), "Файл билета, покажите QR на проходном пункте.", user.getUsername(), pdfService.createQR(pdfService.createContent(ticket), ticket.getId()));
            return "redirect:/history?message=Ticket sended to email " + user.getUsername() +"";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
