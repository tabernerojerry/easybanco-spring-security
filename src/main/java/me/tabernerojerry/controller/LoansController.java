package me.tabernerojerry.controller;

import lombok.RequiredArgsConstructor;
import me.tabernerojerry.model.Loans;
import me.tabernerojerry.repository.ILoanRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoansController {

    private final ILoanRepository loanRepository;

    //    @PreAuthorize("hasRole('USER')")
    @PostAuthorize("hasRole('USER')")
    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam int id) {
        return loanRepository.findByCustomerIdOrderByStartDtDesc(id);
    }

}
