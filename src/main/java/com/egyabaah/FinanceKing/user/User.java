package com.egyabaah.FinanceKing.user;

import java.time.LocalDate;


import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.egyabaah.FinanceKing.accounts.Account;
import com.egyabaah.FinanceKing.roles.Role;
import com.egyabaah.FinanceKing.roles.Roles;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "users",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "email"),
				@UniqueConstraint(columnNames = "phone")
		})
//@Builder
public class User implements Comparable<User>, UserDetails {

	// Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// FirstName of a customer
	private String firstName;
	// MiddleNames of a customer
	private String middleName;
	// LastName of a customer
	private String lastName;
	// Date of birth of a customer
	// Json string matching this format will be converted to LocalDate Object
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
	@OneToMany
	@JoinColumn(name="user_id", referencedColumnName="id")
	public List<Account> accounts;
	// A set of Roles of a user
	@Enumerated(EnumType.STRING)
	private Set<Role> roles = new HashSet<>();

	private boolean isVerified;
	
	// Empty Constructor
	public User() {
		
	}
	
	// Temp constructor
	public User(String firstName, Double creditScore) {
		this.firstName = firstName;
		this.creditScore = creditScore;
	}

	// Constructor without middle name
	public User(String firstName, String lastName, LocalDate dob, String email, String phone, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	// Constructor with middle name
	public User(String firstName, String lastName, LocalDate dob, String email, String phone, String password, String middleName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
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
		return Period.between(this.dob, LocalDate.now()).getYears();
//		return 10;
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
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public void addRoles(Role role){
		this.roles.add(role);
	}
	public void removeRoles(Role role){
		this.roles.remove(role);
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean verified) {
		isVerified = verified;
	}


	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", middleName='" + middleName + '\'' +
				", lastName='" + lastName + '\'' +
				", dob=" + dob +
				", creditScore=" + creditScore +
				", age=" + age +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", password='" + password + '\'' +
				", accounts=" + accounts +
				", roles=" + roles +
				", isVerified=" + isVerified +
				'}';
	}

	@Override
	/**
	 * Compares Customer Accounts Using creditScores then customerId
	 * @param o - CustomerAccount to compare to this 
	 */
	public int compareTo(User o) {
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
	@Transactional
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Role role : getRoles()) {
//			System.out.println(role);
			// Converts Role to string and add to authorities
			authorities.add(new SimpleGrantedAuthority(role.toString()));
			
		}
		return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}





}
