/**
 * 
 */
package com.egyabaah.FinanceKing.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Emmanuel Gyabaah
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
