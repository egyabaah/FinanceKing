/**
 * 
 */
package com.egyabaah.FinanceKing.accounts;

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
	 * Gets an account from database
	 * @param account
	 * @return
	 */
	private Account getAccountById(Account account) {
		// Add to database
		//Return success
		return new Account();
	}
	
	private Account getAccountByEmail(Account account) {
		// Add to database
		//Return success
		return new Account();
	}
	
	private Account getAccountByUsername(Account account) {
		// Add to database
		//Return success
		return new Account();
	}
	private Account getAccountByPhoneNumber(Account account) {
		// Add to database
		//Return success
		return new Account();
	}
	
	private String addAccount(Account account) {
		// Add account to database
		accountRepo.save(account);
		//Return success
		return "success";
	}
	
	private String changePassword(Account account) {
		// Add to database
		//Return success
		return "success";
	}
	
	private String changeEmail(Account account) {
		// Add to database
		//Return success
		return "success";
	}
	
	private String changeUsername(Account account) {
		// Add to database
		//Return success
		return "success";
	}
	
	private String changeDob(Account account) {
		// Add to database
		//Return success
		return "success";
	}
	
	private String removeAccount(Account account) {
		// Add to database
		accountRepo.delete(account);
		//Return success
		return "success";
	}
	
	public List<Account> getAccounts() {
//		return List.of(
//			new Account("Daddy", 20),
//			new Account("France", 23),
//			new Account("Hamburg", Integer.parseInt("30"))
//		);
		addAccount(new Account("Daddy", 20));
		addAccount(new Account("France", 23));
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
