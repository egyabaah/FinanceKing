package com.egyabaah.FinanceKing.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountNumberGeneratorRepository extends JpaRepository<AccountNumberGenerator, Long> {
    Optional<AccountNumberGenerator> findAllByUserId(Long userid);
}
