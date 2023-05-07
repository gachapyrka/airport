package com.example.airport.controllers;

import com.example.airport.domain.*;
import com.example.airport.repos.PlaceRepo;
import com.example.airport.repos.RaiseRepo;
import com.example.airport.repos.TicketRepo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Controller
public class RaisesController {
    private final RaiseRepo raiseRepo;
    private final PlaceRepo placeRepo;
    private final TicketRepo ticketRepo;
    public RaisesController(RaiseRepo raiseRepo, PlaceRepo placeRepo, TicketRepo ticketRepo) {
        this.raiseRepo = raiseRepo;
        this.placeRepo = placeRepo;
        this.ticketRepo = ticketRepo;
    }

    @GetMapping("/raises")
    public String getRaises(Map<String, Object> model) {

        Iterable<Raise> raises = raiseRepo.findByCountOfDays(0);
        model.put("raises", raises);

        return "raises";
    }

    @GetMapping("/tours")
    public String getTours(Map<String, Object> model) {
        Iterable<Raise> raises = raiseRepo.findByCountOfDaysGreaterThan(0);
        model.put("raises", raises);

        return "raises";
    }

    @PostMapping("/add-to-list/{raise}")
    @PreAuthorize("hasAuthority('USER')")
    public String addToList(@PathVariable Raise raise, @AuthenticationPrincipal ClientInfo user, Map<String, Object> model) {
        boolean isAlreadyAdded = false;
        for(Ticket ticket: user.getTickets()){
            if(ticket.getRaise().getId() == raise.getId()){
                ticket.setCount(ticket.getCount()+1);
                ticketRepo.save(ticket);
                isAlreadyAdded=true;
                break;
            }
        }
        if(!isAlreadyAdded)
            ticketRepo.save(new Ticket(user, raise, null, 1));

        return "redirect:/raises";
    }

    @GetMapping("/add-raise")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getRaise(Map<String, Object> model) {

        Iterable<Place> places = placeRepo.findAll();

        model.put("places", places);

        return "add-raise";
    }

    @PostMapping("/add-raise")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String postRaise(@RequestParam String to,
                            @RequestParam String date, @RequestParam String number,
                            @RequestParam Double cost, @RequestParam Integer countOfDays,
                            Map<String, Object> model) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date res = new Date();
        try {
            res = formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        raiseRepo.save(new Raise(placeRepo.findByName(to), res, number, cost, countOfDays, new ArrayList<>()));

        return "redirect:/raises";
    }

    @GetMapping("/add-tour")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getTour(Map<String, Object> model) {

        Iterable<Place> places = placeRepo.findAll();

        model.put("places", places);

        return "add-raise";
    }

    @GetMapping("raises/{raise}")
    public String getRaiseInfo(@PathVariable Raise raise, Model model){
        model.addAttribute("raise", raise);
        return "raise";
    }

    @GetMapping("tours/{raise}")
    public String getTourInfo(@PathVariable Raise raise, Model model){
        model.addAttribute("raise", raise);
        return "raise";
    }
}
