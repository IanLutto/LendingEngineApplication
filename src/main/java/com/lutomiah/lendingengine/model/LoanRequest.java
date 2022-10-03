package com.lutomiah.lendingengine.model;

import com.lutomiah.lendingengine.entity.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Duration;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class LoanRequest {

    private int amount;
    private Long borrowerId;
    private int daysToRepay;
    private double interestRate;

    @Override
    public String toString() {
        return "LoanRequest{" +
                "amount=" + amount +
                ", borrowerId=" + borrowerId +
                ", daysToRepay=" + daysToRepay +
                ", interestRate=" + interestRate +
                '}';
    }
}
