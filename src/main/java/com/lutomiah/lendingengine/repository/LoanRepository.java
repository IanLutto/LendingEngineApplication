package com.lutomiah.lendingengine.repository;

import com.lutomiah.lendingengine.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
