package com.bms.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bms.app.model.LoanDetails;
import com.bms.app.service.LoanService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/v1")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	
	public static final Logger logger = LoggerFactory.getLogger(LoanController.class);
	
	@HystrixCommand(fallbackMethod = "breaker")
	@PostMapping("/applyLoan")
	public LoanDetails applyLoan(@Valid @RequestBody LoanDetails loanDetails) {
		if(loanDetails==null) {
			throw new RuntimeException();
		}
		logger.info("Received Loan details to insert in Db");
		return loanService.applyLoan(loanDetails);
	}
	public LoanDetails breaker(@Valid @RequestBody LoanDetails loanDetails) {
		return null;
	}

}
