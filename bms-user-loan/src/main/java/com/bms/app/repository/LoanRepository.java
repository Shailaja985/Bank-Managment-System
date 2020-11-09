package com.bms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.app.model.LoanDetails;

@Repository
public interface LoanRepository extends JpaRepository<LoanDetails, Long> {

}
