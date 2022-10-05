package com.lutomiah.lendingengine.exceptions;

public class LoanApplicationNotFoundException extends RuntimeException{
    public LoanApplicationNotFoundException(long loanApplicationd) {
        super("Loan Application with id " + loanApplicationd + " not found!");
    }
}
