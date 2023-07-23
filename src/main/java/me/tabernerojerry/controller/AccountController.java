package me.tabernerojerry.controller;

import lombok.RequiredArgsConstructor;
import me.tabernerojerry.model.Accounts;
import me.tabernerojerry.model.Customer;
import me.tabernerojerry.repository.IAccountsRepository;
import me.tabernerojerry.repository.ICustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final IAccountsRepository accountsRepository;
    private final ICustomerRepository customerRepository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findByEmail(email);

        if (customers != null && !customers.isEmpty()) {
            return accountsRepository.findByCustomerId(customers.get(0).getId());
        }

        return null;
    }
}
