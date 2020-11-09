package com.bms.app.data;



import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class UserEntity  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long userId;
	
	@Column(unique = true)
	@NotBlank(message = "Please enter the username")
	@Size(min = 4, max = 12, message = "Username must be of min 4 and max 12 characters")
	private String userName;
	
	private String address;
	private String state;
	private String county;
	
	
	@Column(nullable=false,length=120,unique=true)
	@Email
	private String email;
	private String panNumber;
	private String contactNumber;
	private String dateOfBirth;
	private String accountType;
	@Column(nullable=false,unique=true)
	private long accountNumber=random();
	
	@Column(nullable=false)
	private String password;
	
	
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UserEntity(long userId,
			@NotBlank(message = "Please enter the username") @Size(min = 4, max = 12, message = "Username must be of min 4 and max 12 characters") String userName,
			String address, String state, String county, @Email String email, String panNumber, String contactNumber,
			String dateOfBirth, String accountType,String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.state = state;
		this.county = county;
		this.email = email;
		this.panNumber = panNumber;
		this.contactNumber = contactNumber;
		this.dateOfBirth = dateOfBirth;
		this.accountType = accountType;
		this.password = password;
	}
	
	

	public UserEntity(long userId,
			@NotBlank(message = "Please enter the username") @Size(min = 4, max = 12, message = "Username must be of min 4 and max 12 characters") String userName,
			String address, String state, String county, @Email String email, String panNumber, String contactNumber,
			String dateOfBirth, String accountType, long accountNumber, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.state = state;
		this.county = county;
		this.email = email;
		this.panNumber = panNumber;
		this.contactNumber = contactNumber;
		this.dateOfBirth = dateOfBirth;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.password = password;
	}



	public long getUserId() {
		return userId;
	}

	public void setCustomerId(long userId) {
		this.userId = userId;
	}

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	private long random() {
		long smallest = 1000_0000_0000_0000L;
		long biggest = 9999_9999_9999_9999L;

		long random = ThreadLocalRandom.current().nextLong(smallest, biggest + 1);
		return random;
	}
	
	
	
	

}
