package com.lutomiah.lendingengine.repository;

import com.lutomiah.lendingengine.entity.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
}
