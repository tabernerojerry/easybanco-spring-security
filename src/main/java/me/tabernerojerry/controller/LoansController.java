package me.tabernerojerry.controller;

import lombok.RequiredArgsConstructor;
import me.tabernerojerry.model.Customer;
import me.tabernerojerry.model.Loans;
import me.tabernerojerry.repository.ICustomerRepository;
import me.tabernerojerry.repository.ILoanRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoansController {

    private final ILoanRepository loanRepository;
    private final ICustomerRepository customerRepository;

    @PreAuthorize("hasRole('USER')")
//    @PostAuthorize("hasRole('USER')")
    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findByEmail(email);

        if (customers != null && !customers.isEmpty()) {
            return loanRepository.findByCustomerIdOrderByStartDtDesc(customers.get(0).getId());
        }

        return List.of();
    }

}
