package com.egyabaah.FinanceKing.auth;


import com.egyabaah.FinanceKing.token.Token;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import com.egyabaah.FinanceKing.accounts.Account;
import com.egyabaah.FinanceKing.accounts.AccountRepository;
import com.egyabaah.FinanceKing.config.JwtService;
import com.egyabaah.FinanceKing.token.TokenRepository;
import com.egyabaah.FinanceKing.token.TokenType;

/**
 * @author gyabe
 *
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final AccountRepository accountRepo;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final UserDetailsService userDetailsService;


//public AuthenticationResponse register(RegisterRequest request) {
////    var user = Account.builder()
////        .firstname(request.getFirstname())
////        .lastname(request.getLastname())
////        .email(request.getEmail())
////        .password(passwordEncoder.encode(request.getPassword()))
////        .role(Role.USER)
////        .build();
////    var savedUser = accountRepository.save(user);
//    var jwtToken = jwtService.generateToken(user);
//    saveUserToken(savedUser, jwtToken);
//    return AuthenticationResponse.builder()
//        .token(jwtToken)
//        .build();
//  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    System.out.println("////////////\nHelloldaklj\n////////");
    System.out.println("////////////\n" + request.getEmail() + "  " + request.getPassword() + "\n////////");
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    System.out.println("////////////\nHIMMMMM\n////////");
    var user = (accountRepo.findByEmail(request.getEmail()).isPresent()?accountRepo.findByEmail(request.getEmail()) : accountRepo.findByPhone(request.getEmail()))
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  /**
   * Refreshes(create new token) to prevent user from being logout while still using services
   * @param request
   * @return
   */
  public AuthenticationResponse refreshToken(@NonNull HttpServletRequest request){
    final String authHeader = request.getHeader("Authorization");
    final String userEmail;
    final String jwt;


    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      return null;
    }
    jwt = authHeader.substring(7);
    userEmail = jwtService.extractUsername(jwt);
    if (userEmail != null) {
      UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
      var isTokenValid = tokenRepository.findByToken(jwt)
              .map(t -> !t.isExpired() && !t.isRevoked())
              .orElse(false);
      System.out.println(authHeader);
      if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
        Account user = accountRepo.findByEmail(userEmail).get();

        var jwtToken = jwtService.generateToken(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

      }
    }
    return null;

  }

  private void saveUserToken(Account account, String jwtToken) {
    var token = Token.builder()
        .account(account)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(Account account) {
    var validUserTokens = tokenRepository.findAllValidTokenByAccount(account.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }
}
