/**
 * 
 */
package com.egyabaah.FinanceKing.accounts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Emmanuel Gyabaah
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	// Find all accounts with the last name as lastName
	List<Account> findByLastName(String lastName);
	// Find all accounts with  full name as given arguments
	List<Account> findByFullName(String firstName, String lastName);
	// Find all accounts with full name as given arguments
	List<Account> findByFullName(String firstName, String middleName, String lastName);
	// Find an account by it's email
	Optional<Account> findByEmail(String email);
	// Find an account by the phone number
	Optional<Account> findByPhone(String phone);
	

}
