package com.bms.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bms.app.controller.LoanController;
import com.bms.app.model.LoanDetails;
import com.bms.app.model.UserEntity;
import com.bms.app.repository.LoanRepository;
import com.bms.app.service.LoanServiceImpl;

@SpringBootTest(classes=BmsUserLoanApplication.class)
class BmsUserLoanApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@InjectMocks
	LoanServiceImpl loanServiceImpl;
	
	@InjectMocks
	LoanController loanController;

	@Mock
	LoanRepository loanRepository;

	@Test
	void testApplication() {
		BmsUserLoanApplication.main(
				new String[] { "--spring.main.web-environment=false", "--spring.autoconfigure.exclude=blahblahblah",

				});
	}
	
	@Test
	void testloan() {
		UserEntity userDetails = new UserEntity();

		userDetails.setUserId(100);
		userDetails.setAccountType("sb");
		userDetails.setPanNumber("ABCDEF12345");
		userDetails.setContactNumber("8978127720");
		userDetails.setCounty("Ind");
		userDetails.setState("AP");
		userDetails.setEmail("a@gmail.com");
		userDetails.setAddress("tenali");
		userDetails.setPassword("Prafu@29");
		userDetails.setUserName("prafulla");
		userDetails.setAccountNumber(2213726038414410L);
		
		LoanDetails loanDetails = new LoanDetails();
		loanDetails.setUserDetails(userDetails);
		loanDetails.setDate("11-01-2020");
		loanDetails.setDurationOfLoan("65");
		loanDetails.setLoanAmount(200000L);
		loanDetails.setLoanId(1);
		loanDetails.setLoanType("personal");
		loanDetails.setRateOfInterest("3.5");

		LoanDetails loanDetails1 = new LoanDetails();
		loanDetails1 = loanServiceImpl.applyLoan(loanDetails1);
	}
	
	@Test
	void testbreaker() {
		LoanDetails loanDetails = new LoanDetails();
		UserEntity userDetails = new UserEntity();
		loanDetails = loanController.breaker(null);
	}
	
	@Test
	void testbreaker1() {
		LoanDetails loanDetails = new LoanDetails();
		UserEntity userDetails = new UserEntity();
		loanController.breaker(loanDetails);
	}
	
	@Test
	void testbreaker2() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			LoanDetails loanDetails = new LoanDetails();
			LoanDetails loanDetails1 = new LoanDetails();
			LoanDetails loanDetails2 = new LoanDetails();
			UserEntity userDetails = new UserEntity();
			loanDetails.setUserDetails(userDetails);

			// l1= serviceImpl.applyLoan(l);
			loanDetails1 = loanController.applyLoan(loanDetails);
		});

	}

}