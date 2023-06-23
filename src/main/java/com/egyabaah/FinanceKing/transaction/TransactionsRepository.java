package com.egyabaah.FinanceKing.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
    Optional<Transactions> findByTransactionNumber(String transactionNumber);
    List<Transactions> findAllByTransactionNumber(String transactionNumber);
    List<Transactions> findAllByTransactionType(TransactionType transactionType);
    List<Transactions> findAllByTransactionMethod(TransactionMethod transactionMethod);
//    @Query(value = "SELECT t FROM transactions t WHERE MONTH(t.transactionTime) = :month")
//    List<Transactions> findAllByMonth(Integer month);
//    @Query(value = "SELECT t FROM transactions t WHERE YEAR(t.transactionTime) = :year")
//    List<Transactions> findAllByYear(Integer year);
//    List<Transactions> findAllByDateBetween(Integer year);
//    List<Transactions> findAllByAccount_IdAndTransactionTime_Month(Long account_id, Month transactionTime_month);
    List<Transactions> findAllByAccountAccountNumber(String accountNumber);
//    List<Transactions> findAllByTransactionTime_Month(Month month);
    @Query("select e from transactions e where year(e.transactionTime) = ?1 and month(e.transactionTime) = ?2")
    List<Transactions> getByYearAndMonth(int year, int month);
//    List<Transactions> findAllByAccountAccountNumberAndTransactionTime_Month(@NonNull String account_accountNumber, Month transactionTime_month);
//    List<Transactions> findAllByAccount_AccountNumberAndTransactionTime_Year(@NonNull String account_accountNumber, int transactionTime_year);
}
