package com.bms.app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="loan_details")
public class LoanDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long loanId;

	private String loanType;
	private long loanAmount;
	private String date;
	private String rateOfInterest;
	private String durationOfLoan;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserEntity userEntity;

	public long getLoanId() {
		return loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(String rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public String getDurationOfLoan() {
		return durationOfLoan;
	}

	public void setDurationOfLoan(String durationOfLoan) {
		this.durationOfLoan = durationOfLoan;
	}

	public UserEntity getUserDetails() {
		return userEntity;
	}

	public void setUserDetails(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	
}