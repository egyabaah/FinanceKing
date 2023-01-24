/**
 * 
 */
package com.egyabaah.FinanceKing.accounts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Emmanuel Gyabaah
 *
 */
@RestController
@RequestMapping(path = "api/v1/account")
@CrossOrigin(origins="http://localhost:3000")
public class AccountController {
	
	private final AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("")
	public List<Account> getAccounts() {
		return accountService.getAccounts();
	}
	
	@PostMapping("")
	public String registerNewAccount(@RequestBody Account account) {
		return accountService.addAccount(account);
	}

}
