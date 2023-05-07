package com.example.airport.controllers;

import com.example.airport.domain.Place;
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

//        placesRepo.save(new Place("Милан, Италия", "45.63054343443115, 8.725464600399201", new ArrayList<>()));
//        placesRepo.save(new Place("Париж, Франция", "49.25227951858836, 2.50682599574729", new ArrayList<>()));
//        placesRepo.save(new Place("Барселона, Испания", "41.29757396795772, 2.08446354307997", new ArrayList<>()));
//        placesRepo.save(new Place("Торонто, Канада", "44.102094523366645, -79.35341257490718", new ArrayList<>()));
//        placesRepo.save(new Place("Калифорния, США", "35.40614468993855, -117.99759504414178", new ArrayList<>()));
//        placesRepo.save(new Place("Магадан, Россия", "59.91440219618757, 150.73223112773758", new ArrayList<>()));
//        placesRepo.save(new Place("Тбилиси, Грузия", "41.80098573311602, 45.02887881832473", new ArrayList<>()));
//        placesRepo.save(new Place("Ташкент, Узбекистан", "41.321594929050676, 69.38901563437904", new ArrayList<>()));
//        placesRepo.save(new Place("Варшава, Польша", "52.16513760017753, 20.969160242139697", new ArrayList<>()));
//        placesRepo.save(new Place("Рига, Латвия", "56.922192648404476, 23.979494508179375", new ArrayList<>()));
//        placesRepo.save(new Place("Вена, Австрия", "48.11272711279736, 16.57655459705282", new ArrayList<>()));
//        placesRepo.save(new Place("Вильнюс, Литва", "54.686792402367665, 25.30165980887", new ArrayList<>()));
//        placesRepo.save(new Place("Франкфурт, Германия", "50.03816390884127, 8.563499104449509", new ArrayList<>()));
//        placesRepo.save(new Place("Амстердам, Нидерланды", " 52.41787758797059, 4.691370009621811", new ArrayList<>()));
//        placesRepo.save(new Place("Брюссель, Бельгия", "50.61326979074569, 4.471643456614519", new ArrayList<>()));
//        placesRepo.save(new Place("Женева, Швейцария", "46.29014656632757, 6.103595587761994", new ArrayList<>()));
//        placesRepo.save(new Place("Стамбул, Турция", "42.58444702038581, 28.90581276780081", new ArrayList<>()));
//        placesRepo.save(new Place("Киев, Украина", "50.73097013009004, 30.25596776031292", new ArrayList<>()));
//        placesRepo.save(new Place("Белград, Сербия", "44.92863540045016, 20.257125068636096", new ArrayList<>()));
//        placesRepo.save(new Place("Москва, Россия", "55.44038198120027, 37.906132807269515", new ArrayList<>()));

        return "main";
    }
}
