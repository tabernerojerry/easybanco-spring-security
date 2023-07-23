package me.tabernerojerry.controller;

import lombok.RequiredArgsConstructor;
import me.tabernerojerry.model.Cards;
import me.tabernerojerry.model.Customer;
import me.tabernerojerry.repository.ICardsRepository;
import me.tabernerojerry.repository.ICustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsController {

    private final ICardsRepository cardsRepository;
    private final ICustomerRepository customerRepository;

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findByEmail(email);

        if (customers != null && !customers.isEmpty()) {
            return cardsRepository.findByCustomerId(customers.get(0).getId());
        }

        return null;
    }

}
