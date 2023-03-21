//package com.egyabaah.FinanceKing.accounts;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author Emmanuel Gyabaah
// *
// */
//@RestController
//@RequestMapping(path = "api/v1/auth/user")
//@CrossOrigin(origins="http://localhost:3000")
//public class RegisterController {
//
//	private final UserService accountService;
//
//	@Autowired
//	public RegisterController(UserService accountService) {
//		this.accountService = accountService;
//	}
//
//	@GetMapping("")
//	public List<User> getAccounts() {
//		return accountService.getAccounts();
//	}
//
//	@PostMapping("")
//	public ResponseEntity<String> registerNewAccount(@RequestBody User user) {
//		String result = accountService.addAccount(user);
//		  return new ResponseEntity<>(result, HttpStatus.OK);
//	}
//
//}
