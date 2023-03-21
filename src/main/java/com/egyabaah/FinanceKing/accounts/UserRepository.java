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
public interface UserRepository extends JpaRepository<User, Long> {
	// Find all accounts with the last name as lastName
	List<User> findByLastName(String lastName);
	// Find all accounts with the last name as lastName
	List<User> findByFirstName(String firstName);
	// Find all accounts with  full name as given arguments
//	List<User> findByFullName(String firstName, String lastName);
//	// Find all accounts with full name as given arguments
//	List<User> findByFullName(String firstName, String middleName, String lastName);
	// Find an user by it's email
	Optional<User> findByEmail(String email);
//	 Find an user by the phone number
	Optional<User> findByPhone(String phone);
//	Query("from User u where u.name = :name or u.email = :name"
//	Optional<User> findByUsername(String username);
//

}
