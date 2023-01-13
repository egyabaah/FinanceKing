package com.egyabaah.FinanceKing.accounts;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Account implements Comparable<Account> {

	// Fields
	
	// Customer id
	@Id
	@SequenceGenerator(
			name = "account_sequence",
			sequenceName = "account_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "account_sequence"
			)
	private Long id;
	// FirstName of a customer
	private String firstName;
	// MiddleNames of a customer
	private String middleName;
	// LastName of a customer
	private String lastName;
	// Date of birth of a customer
	private LocalDate dob;
	// Credit score of a customer
	private Double creditScore;
	// Customer's age
	private Integer age;
	// Customer's email
	private String email;
	// Customer's password
	private String password;
	
	// Empty Constructor
	public Account() {
		
	}
	
	// Temp constructor
	public Account(String firstName, Integer age) {
		this.firstName = firstName;
		this.age = age;
	}

	// Constructor
	public Account(String firstName, String middleName, String lastName, LocalDate dob, Double creditScore,
			Integer age, String email, String password) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.creditScore = creditScore;
		this.age = age;
		this.email = email;
		this.password = password;
	}
	
	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public LocalDate getDob() {
		return dob;
	}
	
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public Double getCreditScore() {
		return creditScore;
	}
	
	public void setCreditScore(Double creditScore) {
		this.creditScore = creditScore;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@Override
	/**
	 * Returns string form of CustomerAccount
	 */
	public String toString() {
		return "CustomerAccount [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", dob=" + dob + ", creditScore=" + creditScore + ", age=" + age + ", email=" + email + ", password="
				+ password + ", customerId=" + id + "]";
	}


	@Override
	/**
	 * Compares Customer Accounts Using creditScores then customerId
	 * @param o - CustomerAccount to compare to this 
	 */
	public int compareTo(Account o) {
		// Return 0 if any of the required fields is missing
		if (this == null || o == null || this.id == null || o.id == null ||this.getCreditScore() == null 
				|| o.getCreditScore() == null) {			
			return 0;
		}
		// Result
		int result = this.getCreditScore().compareTo(o.getCreditScore());
		// Incase both customers have same creditScore, compare their customerId's in natural order
		if (result == 0) {
			return this.id.compareTo(o.id);
		}
		// Return customer with highest creditScore
		return result;
	}
	
	
	
	
	


	
	
	
}
