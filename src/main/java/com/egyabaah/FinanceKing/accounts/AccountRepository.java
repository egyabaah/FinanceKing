package com.egyabaah.FinanceKing.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumber(Long accountNumber);
    List<Account> findAllByUserId(Long user_id);
    List<Account> findAllByUserIdAndAccountStatus(Long user_id, AccountStatus accountStatus);
    List<Account> findAllByUserIdAndAccountType(Long user_id, AccountType accountType);
}
