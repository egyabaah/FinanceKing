/**
 * 
 */
package com.egyabaah.FinanceKing.user;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.egyabaah.FinanceKing.roles.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.egyabaah.FinanceKing.roles.Role;


/**
 * @author Emmanuel Gyabaah
 *
 */
@Service
public class UserService {

	// Fields
//	// Instance of UserService to prevent more than one instance running
//	private static UserService instance;
	
	 private final UserRepository userRepository;
	
	// Constructor
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		
	}
	
	/**
	 * Gets an user from database using their id
	 * @param id - Long
	 * @return User - user with same id as id, else null
	 */
	public User getUserById(Long id) {
//		if (userRepository.findById(id).isPresent()) {
//			return userRepository.findById(id).get();
//		}
//		return null;
	
		return userRepository.findById(id).get();
	}
	
	/**
	 * Searches database and return user with same email as given email, else null
	 * @param email
	 * @return User - user with same email as email, else null
	 */
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email).get();
	}
	
	/**
	 * Return user with same first name and last name as given, else null
	 * @param firstName
	 * @param lastName
	 * @return List<User> - List of all user with same first and last names as given,
	 * else null 
	 */
//	public List<User> getUserByFullName(String firstName, String lastName) {
//		return userRepository.findByFullName(firstName, lastName);
//	}
//	
//	/**
//	 * Return user with same first name, middle name and last name as given, else null
//	 * @param firstName
//	 * @param lastName
//	 * @return List<User> - List of all user with same first, middle and last names as given,
//	 * else null 
//	 */
//	public List<User> getUserByFullName(String firstName, String middleName, String lastName) {
//		return userRepository.findByFullName(firstName, middleName, lastName);
//	}
	
	/**
	 * Returns an user from database with same phone number as phone
	 * @param phone - String
	 * @return User - user with same phone number as phone, else null
	 */
	public User getUserByPhoneNumber(String phone) {
		return userRepository.findByPhone(phone).get();
	}
	
	/**
	 * Adds given user to database
	 * User's email and phone number must be unique
	 * @param user - User to add to database
	 * @return String success if account was created successfully else error message
	 */
	public String addUser(User user) {
		// Returns no user data if user is null
		if (user == null) {
			return "No user data";
		}
		// Checks if user email already exists
		else if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			return "Duplicate email";
		}
		// Checks if user phone number already exists
		else if (userRepository.findByPhone(user.getPhone()).isPresent()) {
			return "Duplicate phone";
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role memberRole = Role.ROLE_USER;
		Set<Role> roles = new HashSet<>();
		roles.add(memberRole);
		user.setRoles(roles);
		userRepository.save(user);
		return "success";
	}
	
	/**
	 * Sets the password of the given user to password
	 * This function is called when user is already logged in
	 * Use {@link #resetPassword(String, String)} instead if user is not logged in
	 * @param user - user to change password
	 * @param password - New password
	 * @return success or error depending on process outcome
	 */
	public String changePassword(User user, String password) {
		// Add to database
		//Return success
		return "success";
	}
	
	/**
	 * Sets the password of user with given email to password
	 * This function is called when user is not able to login
	 * Use ({@link #changePassword(User)} instead if user is already logged in
	 * @param email - email of user to change password
	 * @param password - New password
	 * @return success or error depending on process outcome
	 */
	public String resetPassword(String email, String password) {
		User user = getUserByEmail(email);
		if (user != null) {
			user.setPassword(password);
			return "success";
		}
		return "error";
	}
	
	/**
	 * 
	 * Sets the password of the given user email
	 * @param user - user to change email
	 * @param email - New email
	 * @return
	 */
	public String changeEmail(User user, String email) {
		// Add to database
		if (email == null) {
			return "error";
		}
		if (user != null) {
			user.setEmail(email);
			//Return success
			return "success";
		}
		return "error";
	}
	
//	public String changeUsername(User user, String username) {
//		if (user != null) {
//			user.se(email);
//			//Return success
//			return "success";
//		}
//		return "error";
//	}
	
	/**
	 * Sets the dob of a given user to dob
	 * @param user - user to change dob
	 * @param dob - New dob
	 * @return success or error depending on process outcome
	 */
	public String changeDob(User user, LocalDate dob) {
		if (dob == null) {
			return "error";
		}
		if (user != null) {
			user.setDob(dob);
			//Return success
			return "success";
		}
		return "error";
	}
	
	/**
	 * Removes a given user from the database
	 * @param user - User to remove
	 * @return success or error depending on process outcome
	 */
	public String removeUser(User user) {
		if (user != null) {
			userRepository.delete(user);
			return "success";
		}
		return "error";
	}
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}


	
	
}
