package com.egyabaah.FinanceKing.accounts;

import java.time.LocalDate;


import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;

import com.egyabaah.FinanceKing.roles.Role;
import com.egyabaah.FinanceKing.roles.Roles; 


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "accounts", 
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "email"),
				@UniqueConstraint(columnNames = "phone")
		})
public class Account implements Comparable<Account>, UserDetails {

	// Fields
	
	// Customer id
	@Id
//	@SequenceGenerator(
//			name = "account_sequence",
//			sequenceName = "account_sequence",
//			allocationSize = 1)
//	@GeneratedValue(
//			strategy = GenerationType.SEQUENCE,
//			generator = "account_sequence"
//			)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// FirstName of a customer
	private String firstName;
	// MiddleNames of a customer
	private String middleName;
	// LastName of a customer
	private String lastName;
	// Date of birth of a customer
	@JsonFormat(pattern = "dd-MM-yyyy")
	@NotEmpty
	private LocalDate dob;
	// Credit score of a customer
	private Double creditScore;
	// Customer's age
	@Transient
	private Integer age;
	// Customer's email
	@Email
	@NotEmpty
	private String email;
	// Customer's phone number
	@NotEmpty
	private String phone;
	// Customer's password
	@NotEmpty
	private String password;
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(	name = "account_roles", 
//				joinColumns = @JoinColumn(name = "account_id"), 
//				inverseJoinColumns = @JoinColumn(name = "role_id"))
//	@Enumerated(EnumType.STRING)
	private Set<String> roles = new HashSet<>();
	
	// Empty Constructor
	public Account() {
		
	}
	
	// Temp constructor
	public Account(String firstName, Double creditScore) {
		this.firstName = firstName;
		this.creditScore = creditScore;
	}

	// Constructor
	public Account(String firstName, String middleName, String lastName, LocalDate dob, Double creditScore,
			String email, String password) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.creditScore = creditScore;
		this.email = email;
		this.password = password;
	}
	
	public Account(String firstName, String lastName, LocalDate dob, Double creditScore,
			String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.creditScore = creditScore;
		this.email = email;
		this.password = password;
	}
	
	public Account(String firstName, String lastName, LocalDate dob, String email, String phone, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
//		String[] dobList = dob.split("-");
//		this.dob = LocalDate.of(Integer.parseInt(dobList[2]), Integer.parseInt(dobList[1]), Integer.parseInt(dobList[0]));
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	public Account(String firstName, String lastName, LocalDate dob, String email, String phone, String password, String middleName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
//		String[] dobList = dob.split("-");
//		this.dob = LocalDate.of(Integer.parseInt(dobList[2]), Integer.parseInt(dobList[1]), Integer.parseInt(dobList[0]));
		this.dob = dob;
		this.email = email;
		this.phone = phone;
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
//		return Period.between(this.dob, LocalDate.now()).getYears();
		return 10;
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

	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String role: roles) {
			// Converts Role to string and add to authorities
			authorities.add(new SimpleGrantedAuthority(role.toString()));
			
		}
		return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	


	
	
	
}
