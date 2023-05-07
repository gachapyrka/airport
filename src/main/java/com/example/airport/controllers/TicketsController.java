package com.example.airport.controllers;

import com.example.airport.domain.BoughtTicket;
import com.example.airport.domain.ClientInfo;
import com.example.airport.domain.Ticket;
import com.example.airport.repos.BoughtTicketRepo;
import com.example.airport.repos.TicketRepo;
import com.example.airport.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TicketsController {

    private final TicketRepo ticketRepo;
    private final BoughtTicketRepo boughtTicketRepo;
    private final UserService userService;

    public TicketsController(TicketRepo ticketRepo, BoughtTicketRepo boughtTicketRepo, UserService userService) {
        this.ticketRepo = ticketRepo;
        this.boughtTicketRepo = boughtTicketRepo;
        this.userService = userService;
    }

    @GetMapping
    public String getTickets(@AuthenticationPrincipal ClientInfo user, Model model){
        List<Ticket> lst = new ArrayList<>();
        for(Ticket t: ticketRepo.findAllByClientInfo_Id(user.getId())){
            if(t.getBoughtTicket()==null){
                lst.add(t);
            }
        }
        model.addAttribute("tickets", lst);
        model.addAttribute("user", user);
        model.addAttribute("discount", userService.calculateDiscount(user));
        return "tickets";
    }

    @GetMapping("/buy/{ticket}")
    public String getBuyTicket(@PathVariable Ticket ticket, @AuthenticationPrincipal ClientInfo user, Model model){
        model.addAttribute("ticket", ticket);
        model.addAttribute("user", user);
        return "buy-ticket";
    }

    @PostMapping("/buy/{ticket}")
    public String postBuyTicket(@PathVariable Ticket ticket,
                                @RequestParam String passportId,
                                @RequestParam String credentials,
                                Model model){

        boughtTicketRepo.save(new BoughtTicket(ticket, passportId, credentials, new Date()));
        return "redirect:/tickets";
    }

    @PostMapping("/delete/{ticket}")
    public String deleteTicket(@PathVariable Ticket ticket, Model model){
        ticketRepo.delete(ticket);
        return "redirect:/tickets";
    }
}
