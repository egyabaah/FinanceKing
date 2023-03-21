/**
 * 
 */
package com.egyabaah.FinanceKing.config;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.egyabaah.FinanceKing.accounts.AccountRepository;
//import com.egyabaah.FinanceKing.accounts.AccountaccountRepo;

/**
 * @author gyabe
 *
 */
@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {



	private final AccountRepository accountRepo;
		
	// Constructor
//	@Autowired
//	public ApplicationConfig(AccountRepository accountRepo) {
//		this.accountRepo = accountRepo;
//
//	}

  @Bean
  public UserDetailsService userDetailsService() {
	// Checks if a phone number or email matches user's inputted username
    return username -> (accountRepo.findByEmail(username).isPresent()?accountRepo.findByEmail(username) : accountRepo.findByPhone(username))
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
