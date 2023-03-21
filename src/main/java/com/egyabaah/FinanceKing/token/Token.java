/**
 * 
 */
package com.egyabaah.FinanceKing.token;

import com.egyabaah.FinanceKing.accounts.Account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
/**
 * @author gyabe
 *
 */

//@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="token")
public class Token {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Column(unique = true)
  public String token;

  @Enumerated(EnumType.STRING)
  public TokenType tokenType = TokenType.BEARER;

  public boolean revoked;

  public boolean expired;

  @ManyToOne
  @JoinColumn(name = "accounts_id")
  public Account account;
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

public TokenType getTokenType() {
	return tokenType;
}

public void setTokenType(TokenType tokenType) {
	this.tokenType = tokenType;
}

public boolean isRevoked() {
	return revoked;
}

public void setRevoked(boolean revoked) {
	this.revoked = revoked;
}

public boolean isExpired() {
	return expired;
}

public void setExpired(boolean expired) {
	this.expired = expired;
}

public Account getAccount() {
	return account;
}

public void setAccount(Account account) {
	this.account = account;
}
  
  
}
