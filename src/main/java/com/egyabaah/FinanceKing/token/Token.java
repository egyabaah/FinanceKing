/**
 * 
 */
package com.egyabaah.FinanceKing.token;

import com.egyabaah.FinanceKing.accounts.Account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
  @GeneratedValue
  public Integer id;

  @Column(unique = true)
  public String token;

  @Enumerated(EnumType.STRING)
  public TokenType tokenType = TokenType.BEARER;

  public boolean revoked;

  public boolean expired;

  @ManyToOne
  @JoinColumn(name = "account_id")
  public Account account;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
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
