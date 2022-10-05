package com.lutomiah.lendingengine.service;

import com.lutomiah.lendingengine.entity.Loan;
import com.lutomiah.lendingengine.entity.LoanApplication;
import com.lutomiah.lendingengine.entity.User;
import com.lutomiah.lendingengine.exceptions.LoanApplicationNotFoundException;
import com.lutomiah.lendingengine.exceptions.UserNotFoundException;
import com.lutomiah.lendingengine.repository.LoanApplicationRepository;
import com.lutomiah.lendingengine.repository.LoanRepository;
import com.lutomiah.lendingengine.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private final LoanApplicationRepository loanApplicationRepository;
    private final UserRepository userRepository;
    private final LoanRepository loanRepository;

    public LoanService(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository, LoanRepository loanRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.userRepository = userRepository;
        this.loanRepository = loanRepository;
    }

    public void acceptLoan(final Long loanApplicationId, final Long lenderId){
        User lender = userRepository.findById(lenderId).orElseThrow(() -> new UserNotFoundException(lenderId));
        LoanApplication loanApplication = loanApplicationRepository.findById(loanApplicationId)
                .orElseThrow(() -> new LoanApplicationNotFoundException(loanApplicationId));
        loanRepository.save(new Loan(lender, loanApplication));
    }

    public List<Loan> getLoans(){
        return loanRepository.findAll();
    }
}
