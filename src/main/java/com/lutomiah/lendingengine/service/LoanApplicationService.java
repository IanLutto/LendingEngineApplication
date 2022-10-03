package com.lutomiah.lendingengine.service;

import com.lutomiah.lendingengine.entity.LoanApplication;
import com.lutomiah.lendingengine.entity.User;
import com.lutomiah.lendingengine.exceptions.UserNotFoundException;
import com.lutomiah.lendingengine.model.LoanRequest;
import com.lutomiah.lendingengine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

@Service
@Component
public class LoanApplicationService {

    private final UserRepository userRepository;

    @Autowired
    public LoanApplicationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoanApplication transform(LoanRequest request){
        Optional<User> user = userRepository.findById(request.getBorrowerId());

        if (user.isPresent()){
//            LoanApplication loanApplication = new LoanApplication();
//            loanApplication.setAmount(request.getAmount());
//            loanApplication.setBorrower(request.getBorrowerId());
//            loanApplication.setRepaymentTerm(request.getDaysToRepay());
//            loanApplication.setInterestRate(request.getInterestRate());

            return new LoanApplication(request.getBorrowerId(), request.getAmount(), user.get(), Duration.ofDays(request.getDaysToRepay()), request.getInterestRate());
        }else {
            throw new UserNotFoundException(request.getBorrowerId());
        }
    }
}
