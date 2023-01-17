/**
 * 
 */
package com.egyabaah.FinanceKing.accounts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Emmanuel Gyabaah
 *
 */
@Service
public class AccountService {

	// Fields
//	// Instance of AccountService to prevent more than one instance running
//	private static AccountService instance;
	
	 private final AccountRepository accountRepo;
	
	// Constructor
	@Autowired
	public AccountService(AccountRepository accountRepo) {
		this.accountRepo = accountRepo;
		
	}
	
	/**
	 * Gets an account from database using their id
	 * @param id - Long
	 * @return Account - account with same id as id, else null 
	 */
	public Account getAccountById(Long id) {
//		if (accountRepo.findById(id).isPresent()) {
//			return accountRepo.findById(id).get();
//		}
//		return null;
	
		return accountRepo.findById(id).get();
	}
	
	/**
	 * Searches database and return account with same email as given email, else null
	 * @param email
	 * @return Account - account with same email as email, else null 
	 */
	public Account getAccountByEmail(String email) {
		return accountRepo.findByEmail(email).get();
	}
	
	/**
	 * Return accounts with same first name and last name as given, else null
	 * @param firstName
	 * @param lastName
	 * @return List<Account> - List of all accounts with same first and last names as given, 
	 * else null 
	 */
	public List<Account> getAccountByFullName(String firstName, String lastName) {
		return accountRepo.findByFullName(firstName, lastName);
	}
	
	/**
	 * Return accounts with same first name, middle name and last name as given, else null
	 * @param firstName
	 * @param lastName
	 * @return List<Account> - List of all accounts with same first, middle and last names as given, 
	 * else null 
	 */
	public List<Account> getAccountByFullName(String firstName, String middleName, String lastName) {
		return accountRepo.findByFullName(firstName, middleName, lastName);
	}
	
	/**
	 * Returns an account from database with same phone number as phone
	 * @param phone - String
	 * @return Account - account with same phone number as phone, else null 
	 */
	public Account getAccountByPhoneNumber(String phone) {
		return accountRepo.findByPhone(phone).get();
	}
	
	/**
	 * Adds given account to database
	 * @param account - Account to add to database
	 * @return
	 */
	public String addAccount(Account account) {
		if (account != null) {			
			accountRepo.save(account);
			return "success";
		}
		return "error";
	}
	
	/**
	 * Sets the password of the given account to password
	 * This function is called when user is already logged in
	 * Use {@link #resetPassword(String, String)} instead if user is not logged in
	 * @param account - account to change password
	 * @param password - New password
	 * @return success or error depending on process outcome
	 */
	public String changePassword(Account account, String password) {
		// Add to database
		//Return success
		return "success";
	}
	
	/**
	 * Sets the password of account with given email to password
	 * This function is called when user is not able to login
	 * Use ({@link #changePassword(Account)} instead if user is already logged in
	 * @param email - email of account to change password
	 * @param password - New password
	 * @return success or error depending on process outcome
	 */
	public String resetPassword(String email, String password) {
		Account account = getAccountByEmail(email);
		if (account != null) {
			account.setPassword(password);
			return "success";
		}
		return "error";
	}
	
	/**
	 * 
	 * Sets the password of the given account email
	 * @param account - 
	 * @param email - 
	 * @return
	 */
	public String changeEmail(Account account, String email) {
		// Add to database
		if (email == null) {
			return "error";
		}
		if (account != null) {
			account.setEmail(email);
			//Return success
			return "success";
		}
		return "error";
	}
	
//	public String changeUsername(Account account, String username) {
//		if (account != null) {
//			account.se(email);
//			//Return success
//			return "success";
//		}
//		return "error";
//	}
	
	/**
	 * Sets the dob of a given account to dob
	 * @param account - account to change dob
	 * @param dob - New dob
	 * @return success or error depending on process outcome
	 */
	public String changeDob(Account account, LocalDate dob) {
		if (dob == null) {
			return "error";
		}
		if (account != null) {
			account.setDob(dob);
			//Return success
			return "success";
		}
		return "error";
	}
	
	/**
	 * Removes a given account from the database
	 * @param account - Account to remove
	 * @return success or error depending on process outcome
	 */
	public String removeAccount(Account account) {
		if (account != null) {
			accountRepo.delete(account);
			return "success";
		}
		return "error";
	}
	
	public List<Account> getAccounts() {
//		return List.of(
//			new Account("Daddy", 20),
//			new Account("France", 23),
//			new Account("Hamburg", Integer.parseInt("30"))
//		);
		addAccount(new Account("Daddy", 20.0));
		addAccount(new Account("France", 89.9));
		addAccount(new Account("Name", 45.7));
		return accountRepo.findAll();
	}

	/**
	 * Returns an instance of AccountService if one already exits, else 
	 * create a new instance of AccountService and return it
	 * @return AccountService - an instance of AccountService
	 */
//	public static AccountService getInstance() {
//		// Initialize an instance of AccountService if one doesn't exist
//		if (AccountService.instance == null) {
//			AccountService.setInstance(new AccountService());
//		}
//		// Returns instance of AccountService
//		return instance;
//	}
//
//	public static void setInstance(AccountService instance) {
//		AccountService.instance = instance;
//	}
	
	
}
