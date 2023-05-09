package com.example.airport.controllers;

import com.example.airport.domain.ClientInfo;
import com.example.airport.domain.Place;
import com.example.airport.domain.Role;
import com.example.airport.repos.ClientInfoRepo;
import com.example.airport.repos.PlaceRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class MainController {
    private final ClientInfoRepo clientRepo;
    private final PlaceRepo placesRepo;

    public MainController(ClientInfoRepo clientRepo, PlaceRepo placesRepo) {
        this.clientRepo = clientRepo;
        this.placesRepo = placesRepo;
    }

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        //clientRepo.save(new ClientInfo("admin@admin.com", "admin", Role.ADMIN, true, new ArrayList<>(), new ArrayList<>()));

//        placesRepo.save(new Place("Милан, Италия", "https://www.google.com/maps/d/u/3/embed?mid=1MVT4lO3nX71pFdJJ9z4ENiaAqxbSWnI&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Париж, Франция", "https://www.google.com/maps/d/u/3/embed?mid=153CCX6kDdUQX_IwkTgbt1XbvDBo13BI&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Барселона, Испания", "https://www.google.com/maps/d/u/3/embed?mid=1GuqTDfJxJX3aQQDxghoiLZy2cvHhZ1c&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Торонто, Канада", "https://www.google.com/maps/d/u/3/embed?mid=1I0dc4w2V6JDXw2deQ1PC1TtyQqhIb9A&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Калифорния, США", "https://www.google.com/maps/d/u/3/embed?mid=1HVnn0tTGU1d68mBwxhoDB0-psukiuqQ&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Магадан, Россия", "https://www.google.com/maps/d/u/3/embed?mid=1UquuO6zudrQFwhwCAHcefSlKGSM0-c0&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Тбилиси, Грузия", "https://www.google.com/maps/d/u/3/embed?mid=1pa_ZtntY_ltODTJc2PZKRqqYdu1vKtw&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Ташкент, Узбекистан", "https://www.google.com/maps/d/u/3/embed?mid=1J-exs2sRXxjAZMUGZh5arBXNrV71eJU&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Варшава, Польша", "https://www.google.com/maps/d/u/3/embed?mid=1K09TAMW7f_foVt-A9m5cCtWhPAFGrvE&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Рига, Латвия", "https://www.google.com/maps/d/u/3/embed?mid=1W6k2uin3CGFZsap9w7cK5FxmkjFGnrA&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Вена, Австрия", "https://www.google.com/maps/d/u/3/embed?mid=1A6mpZn1sro-UhSVCCS82SzZbcpdwBKI&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Вильнюс, Литва", "https://www.google.com/maps/d/u/3/embed?mid=1-SZeUxYp3mLqFzA9XWemvGd3WYG_fdk&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Франкфурт, Германия", "https://www.google.com/maps/d/u/3/embed?mid=1SP-vmhSAVvhUq2AEQMeT8eZdjK4j3Bs&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Амстердам, Нидерланды", "https://www.google.com/maps/d/u/3/embed?mid=1SQoN3ITi8JamWq83z22di0NwZpWRgFE&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Брюссель, Бельгия", "https://www.google.com/maps/d/u/3/embed?mid=1nFgWMSmzlfMLIZnePssrzz5dcHNnoH8&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Женева, Швейцария", "https://www.google.com/maps/d/u/3/embed?mid=1gX-mU1JO4WiS7PbsRS0BQwd6dgeQigg&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Стамбул, Турция", "https://www.google.com/maps/d/u/3/embed?mid=1-8pcza4g0c6KjTLGNrhhSVJCYTviZA8&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Киев, Украина", "https://www.google.com/maps/d/u/3/embed?mid=1YTatEbhIdf5bDgkXmzru0DO0zCsttMQ&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Белград, Сербия", "https://www.google.com/maps/d/u/3/embed?mid=1SqywWzNE19kpRQ5P2raOPnKi3q2baLM&ehbc=2E312F", new ArrayList<>()));
////        placesRepo.save(new Place("Москва, Россия", "https://www.google.com/maps/d/u/3/embed?mid=1Lh1mGhTSdqG95WHi6Qu7xDR1zq621dg&ehbc=2E312F", new ArrayList<>()));

        return "main";
    }
}
