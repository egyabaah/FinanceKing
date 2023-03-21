package com.egyabaah.FinanceKing.auth;

import com.egyabaah.FinanceKing.accounts.Account;
import com.egyabaah.FinanceKing.accounts.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author gyabe
 *
 */


@RestController
@RequestMapping("/api/v1/auth/account")
//@CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  private final AccountService accountService;
  


@PostMapping("/register")
  public ResponseEntity<String> register(
      @RequestBody Account account
  ) {
    String result = accountService.addAccount(account);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/reauthenticate")
  public ResponseEntity<AuthenticationResponse> reAuthenticate(
          HttpServletRequest request
  ) {
    return ResponseEntity.ok(service.refreshToken(request));
  }

}

