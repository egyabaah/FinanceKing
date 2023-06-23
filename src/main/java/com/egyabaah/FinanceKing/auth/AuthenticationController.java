package com.egyabaah.FinanceKing.auth;

import com.egyabaah.FinanceKing.accounts.Account;
import com.egyabaah.FinanceKing.accounts.AccountService;
import com.egyabaah.FinanceKing.user.User;
import com.egyabaah.FinanceKing.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gyabe
 *
 */


@RestController
@RequestMapping("/api/v1/auth/user")
//@CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  private final UserService userService;
  private final AccountService accountService;




  @GetMapping("")
  public List<User> getAccounts() {
      return userService.getUsers();
  }
  @Transactional
  @PostMapping("/register")
  public ResponseEntity<String> register(
      @RequestBody User user
  ) {
    String result = userService.addUser(user);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping("/create-account")
  @Transactional
  public ResponseEntity<String> createAccount(HttpServletRequest request) throws Exception {
    AuthenticationResponse refreshToken = service.refreshToken(request);
    if(refreshToken != null ){
      return ResponseEntity.ok(accountService.createAccount(service.getUser()));
    }
    return ResponseEntity.ok("Error");
  }

  @Transactional
  @PostMapping("/get-all-accounts")
  public ResponseEntity<String> getAccounts(HttpServletRequest request){
    AuthenticationResponse refreshToken = service.refreshToken(request);
    if(refreshToken != null ){
      System.out.println(service.getUser());
//      @Transactional
//      service.getUser().getAuthorities();
      return ResponseEntity.ok(accountService.getAllAccountsOfUser(service.getUser()).toString());
//      return ResponseEntity.ok("jlk");
    }
    return ResponseEntity.ok(null);
  }

  @PostMapping("/authenticate")
  @Transactional
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @Transactional
  @PostMapping("/reauthenticate")
  public ResponseEntity<AuthenticationResponse> reAuthenticate(
          HttpServletRequest request
  ) {
    return ResponseEntity.ok(service.refreshToken(request));
  }

}

