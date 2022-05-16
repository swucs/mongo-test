package com.example.mongotest.web;

import com.example.mongotest.data.Account;
import com.example.mongotest.data.AccountRepository;
import com.example.mongotest.data.Event;
import com.example.mongotest.data.GeoDto;
import com.example.mongotest.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;

    private final EventService eventService;

    @PostMapping("/account")
    @ResponseBody
    public String createAccount(@RequestBody GeoDto geoDto) {
        Account temp = new Account();
        temp.setUsername("새로운 글!");
        temp.setLocation(new GeoJsonPoint(Double.parseDouble(geoDto.getLatitude()), Double.parseDouble(geoDto.getLongtitude())));

        return accountRepository.save(temp).getId();
    }

    @GetMapping("/account")
    public String page() {
        return "account";
    }

    @GetMapping("/create100Events")
    @ResponseBody
    public String create100Events() {
        eventService.insert100Events(new Event());
        return "success";
    }

    @GetMapping("/event/{id}")
    @ResponseBody
    public Event getEvent(@PathVariable String id) {
        Event event = eventService.getEvent(id);
        return event;
    }
}
