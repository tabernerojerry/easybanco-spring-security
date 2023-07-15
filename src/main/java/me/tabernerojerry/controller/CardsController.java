package me.tabernerojerry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/my-cards")
    public String getCardsDetails() {
        return "Cards details from the database";
    }

}
