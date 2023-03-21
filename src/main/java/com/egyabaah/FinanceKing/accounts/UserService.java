/**
 * 
 */
package com.egyabaah.FinanceKing.accounts;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	public User getAccountById(Long id) {
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
	public User getAccountByEmail(String email) {
		return userRepository.findByEmail(email).get();
	}
	
	/**
	 * Return accounts with same first name and last name as given, else null
	 * @param firstName
	 * @param lastName
	 * @return List<User> - List of all accounts with same first and last names as given,
	 * else null 
	 */
//	public List<User> getAccountByFullName(String firstName, String lastName) {
//		return userRepository.findByFullName(firstName, lastName);
//	}
//	
//	/**
//	 * Return accounts with same first name, middle name and last name as given, else null
//	 * @param firstName
//	 * @param lastName
//	 * @return List<User> - List of all accounts with same first, middle and last names as given,
//	 * else null 
//	 */
//	public List<User> getAccountByFullName(String firstName, String middleName, String lastName) {
//		return userRepository.findByFullName(firstName, middleName, lastName);
//	}
	
	/**
	 * Returns an user from database with same phone number as phone
	 * @param phone - String
	 * @return User - user with same phone number as phone, else null
	 */
	public User getAccountByPhoneNumber(String phone) {
		return userRepository.findByPhone(phone).get();
	}
	
	/**
	 * Adds given user to database
	 * @param user - User to add to database
	 * @return
	 */
	public String addAccount(User user) {
		if (user == null) {
			return "No data";
		}
		else if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			return "Duplicate email";
		}
		else if (userRepository.findByPhone(user.getPhone()).isPresent()) {
			return "Duplicate phone";
		}
		else {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			String memberRole = Role.ROLE_USER.toString();
			Set<String> roles = new HashSet<>();
			roles.add(memberRole);
			System.out.println(Arrays.toString(roles.toArray()));
			user.setRoles(roles);
			userRepository.save(user);
			System.out.println("////////////\n" + user.toString() + "\n////////");
			return "success";
		}
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
		User user = getAccountByEmail(email);
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
	public String removeAccount(User user) {
		if (user != null) {
			userRepository.delete(user);
			return "success";
		}
		return "error";
	}
	
	public List<User> getAccounts() {
//		return List.of(
//			new User("Daddy", 20),
//			new User("France", 23),
//			new User("Hamburg", Integer.parseInt("30"))
//		);
//		addAccount(new User("Daddy", 20.0));
//		addAccount(new User("France", 89.9));
//		addAccount(new User("UK", 45.7));
		return userRepository.findAll();
	}

	/**
	 * Returns an instance of UserService if one already exits, else
	 * create a new instance of UserService and return it
	 * @return UserService - an instance of UserService
	 */
//	public static UserService getInstance() {
//		// Initialize an instance of UserService if one doesn't exist
//		if (UserService.instance == null) {
//			UserService.setInstance(new UserService());
//		}
//		// Returns instance of UserService
//		return instance;
//	}
//
//	public static void setInstance(UserService instance) {
//		UserService.instance = instance;
//	}
	
	
}
