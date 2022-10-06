package com.sixdee.hibernte.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
    private long customerId;
	
	@Column(name = "first_name" ,nullable =false)
	private String firstName;
	
	@Column(name ="username_name")
	private String userName;
	
	@Column(name ="last_name")
	private String lastName;
	
	@Column(name ="age")
	public int age;
	
	@Column(name ="address")
	private String address;
	
	@Column(name ="mobile_number")
	private String mobileNumber;
	
	@Column(name ="email")
	private String emailId;
	
	@Column(name ="date_of_birth")
	private String dateOfBirth;
	
	@Column(name ="bal")
	private int balance;

	public Customer(long customerId, String firstName, String userName, String lastName, int age, String address,
			String mobileNumber, String emailId, String dateOfBirth, int balance) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.userName = userName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.balance = balance;
	}

	public Customer() {
		super();
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", userName=" + userName
				+ ", lastName=" + lastName + ", age=" + age + ", address=" + address + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", balance=" + balance + "]";
	}	
	
	
}
