package com.egyabaah.FinanceKing.accounts;


import com.egyabaah.FinanceKing.transaction.Transactions;
import com.egyabaah.FinanceKing.transaction.TransactionsRepository;
import com.egyabaah.FinanceKing.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountNumberGeneratorRepository accountNumberGeneratorRepository;
    private  final TransactionsRepository transactionsRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository, AccountNumberGeneratorRepository accountNumberGeneratorRepository, TransactionsRepository transactionsRepository){
        this.accountRepository = accountRepository;
        this.accountNumberGeneratorRepository = accountNumberGeneratorRepository;
        this.transactionsRepository = transactionsRepository;
    }

    /**
     *
     * @param user
     * @return
     * @throws Exception
     */
    public String createAccount(User user) throws Exception{
        AccountNumberGenerator accountNumberGenerator = new AccountNumberGenerator(user);
        accountNumberGeneratorRepository.save(accountNumberGenerator);
        Account account = new Account(user, accountNumberGenerator.getAccountNumber());
        accountRepository.save(account);
        Transactions transactions = new Transactions(accountRepository.findByAccountNumber(account.getAccountNumber()).get(), LocalDateTime.now());
        transactionsRepository.save(transactions);

        return "success";
    }
    public List<Account> getAllAccountsOfUser(User user){
        System.out.println(user);

        return accountRepository.findAllByUserId(user.getId());

    }
}
