package me.tabernerojerry.controller;

import lombok.RequiredArgsConstructor;
import me.tabernerojerry.model.AccountTransactions;
import me.tabernerojerry.model.Customer;
import me.tabernerojerry.repository.IAccountTransactionsRepository;
import me.tabernerojerry.repository.ICustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final IAccountTransactionsRepository accountTransactionsRepository;
    private final ICustomerRepository customerRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findByEmail(email);

        if (customers != null && !customers.isEmpty()) {
            return accountTransactionsRepository.
                    findByCustomerIdOrderByTransactionDtDesc(customers.get(0).getId());
        }

       return null;
    }
}
