package com.lutomiah.lendingengine.controller;

import com.lutomiah.lendingengine.entity.Loan;
import com.lutomiah.lendingengine.entity.LoanApplication;
import com.lutomiah.lendingengine.entity.User;
import com.lutomiah.lendingengine.model.LoanRequest;
import com.lutomiah.lendingengine.repository.LoanApplicationRepository;
import com.lutomiah.lendingengine.repository.UserRepository;
import com.lutomiah.lendingengine.service.LoanApplicationService;
import com.lutomiah.lendingengine.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {

    private final LoanApplicationRepository loanApplicationRepository;
    private final UserRepository userRepository;
    private final LoanApplicationService loanApplicationService;
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository, LoanApplicationService loanApplicationService, LoanService loanService) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.userRepository = userRepository;
        this.loanApplicationService = loanApplicationService;
        this.loanService = loanService;
    }

    @PostMapping("/loan/request")
    public void requestLoan(@RequestBody final LoanRequest loanRequest){
        LoanApplication loanApplication = loanApplicationService.transform(loanRequest);
        loanApplicationRepository.save(loanApplication);
    }

    @GetMapping(value = "/loan/requests")
    public List<LoanApplication> findLoanRequests(){
        return loanApplicationRepository.findAll();
    }

    @GetMapping(value = "/users")
    public List<User> findUsers(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/loan/accept/{lenderId}/{loanApplicationId}")
    public void acceptLoan(@PathVariable final String lenderId, @PathVariable final String loanApplicationId){
        loanService.acceptLoan(Long.parseLong(lenderId),Long.parseLong(loanApplicationId));
    }

    @GetMapping(value = "/loans")
    public List<Loan> getAllLoans(){
        return loanService.getLoans();
    }
}
