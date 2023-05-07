package com.example.airport.controllers;

import com.example.airport.repos.ClientInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ClientInfoRepo userRepo;

    @GetMapping
    public String getUsers(Model model){
        model.addAttribute("usrs", userRepo.findAll());
        return "users";
    }
}
