package com.example.airport.controllers;

import com.example.airport.domain.ClientInfo;
import com.example.airport.domain.Role;
import com.example.airport.repos.ClientInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class MainController {
    private final ClientInfoRepo clientRepo;

    public MainController(ClientInfoRepo clientRepo) {
        this.clientRepo = clientRepo;
    }
    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        Iterable<ClientInfo> users = clientRepo.findAll();
        model.put("users", users);
        return "greeting";
    }

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        //clientRepo.save(new ClientInfo("admin", "admin", Role.ADMIN, true, new ArrayList<>()));
        Iterable<ClientInfo> users = clientRepo.findAll();
        model.put("users", users);
        return "main";
    }
}