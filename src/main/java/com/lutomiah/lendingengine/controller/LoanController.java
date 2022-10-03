package com.lutomiah.lendingengine.controller;

import com.lutomiah.lendingengine.entity.LoanApplication;
import com.lutomiah.lendingengine.entity.User;
import com.lutomiah.lendingengine.model.LoanRequest;
import com.lutomiah.lendingengine.repository.LoanApplicationRepository;
import com.lutomiah.lendingengine.repository.UserRepository;
import com.lutomiah.lendingengine.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

    private final LoanApplicationRepository loanApplicationRepository;
    private final UserRepository userRepository;
    private final LoanApplicationService loanApplicationService;

    @Autowired
    public LoanController(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository, LoanApplicationService loanApplicationService) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.userRepository = userRepository;
        this.loanApplicationService = loanApplicationService;
    }

    @PostMapping("/loan/request")
    public void requestLoan(@RequestBody final LoanRequest loanRequest){
        LoanApplication loanApplication = loanApplicationService.transform(loanRequest);
        loanApplicationRepository.save(loanApplication);
    }

    @GetMapping(value = "/users")
    public List<User> findUsers(){
        return userRepository.findAll();
    }
}
