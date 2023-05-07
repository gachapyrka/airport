package com.example.airport.controllers;

import com.example.airport.domain.Place;
import com.example.airport.domain.Raise;
import com.example.airport.repos.PlaceRepo;
import com.example.airport.repos.RaiseRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Controller
public class RaisesController {
    private final RaiseRepo raiseRepo;
    private final PlaceRepo placeRepo;
    public RaisesController(RaiseRepo raiseRepo, PlaceRepo placeRepo) {
        this.raiseRepo = raiseRepo;
        this.placeRepo = placeRepo;
    }

    @GetMapping("/raises")
    public String getRaises(Map<String, Object> model) {

        Iterable<Raise> raises = raiseRepo.findAll();
        model.put("raises", raises);

        return "raises";
    }

    @GetMapping("/tours")
    public String getTours(Map<String, Object> model) {
        Iterable<Raise> raises = raiseRepo.findAll();
        model.put("raises", raises);

        return "raises";
    }

    @GetMapping("/add-raise")
    public String getRaise(Map<String, Object> model) {

        Iterable<Place> places = placeRepo.findAll();

        model.put("places", places);
        model.put("isTour", false);

        return "redirect:/add-raise";
    }

    @PostMapping("/add-raise")
    public String postRaise(@RequestParam String from, @RequestParam String to,
                            @RequestParam Date date, @RequestParam String number,
                            @RequestParam Double cost, @RequestParam Integer countOfDays,
                            Map<String, Object> model) {

        raiseRepo.save(new Raise(placeRepo.findByName(from), placeRepo.findByName(to), date, number, cost, countOfDays, new ArrayList<>()));

        return "redirect:/raises";
    }

    @GetMapping("/add-tour")
    public String getTour(Map<String, Object> model) {

        Iterable<Place> places = placeRepo.findAll();

        model.put("places", places);
        model.put("isTour", true);

        return "redirect:/add-raise";
    }

    @PostMapping("/add-tour")
    public String postTour(@RequestParam String to,
                            @RequestParam Date date, @RequestParam String number,
                            @RequestParam Double cost, @RequestParam Integer countOfDays,
                            Map<String, Object> model) {

        raiseRepo.save(new Raise(placeRepo.findByName("Минск, Беларусь"), placeRepo.findByName(to), date, number, cost, countOfDays, new ArrayList<>()));

        return "redirect:/raises";
    }


}
