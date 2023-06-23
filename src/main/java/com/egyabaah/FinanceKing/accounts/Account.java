package com.egyabaah.FinanceKing.accounts;

import com.egyabaah.FinanceKing.transaction.Transactions;

import com.egyabaah.FinanceKing.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="accounts")
@Getter
@Setter
@AllArgsConstructor
//@ToString
//@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private Long accountNumber;
    @NonNull
    private AccountType accountType;

    @NonNull
    private Long balance;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;
    @OneToMany
    @JoinColumn(name="account_id", referencedColumnName="id")
    public List<Transactions> transactionList;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    private boolean isLocked;

    private boolean isDisabled;


    @Builder
    public Account(@NonNull Long balance, AccountStatus accountStatus, boolean isLocked, boolean isDisabled, @NonNull User user) {
        this.user = user;
        this.balance = balance;
        this.accountStatus = accountStatus;
        this.isLocked = isLocked;
        this.isDisabled = isDisabled;
        this.accountNumber = new AccountNumberGenerator(user).getAccountNumber();

    }
    @Builder
    public Account(@NonNull Long balance, AccountStatus accountStatus, @NonNull User user) {
        this.user = user;
        this.balance = balance;
        this.accountStatus = accountStatus;
        this.isLocked = false;
        this.isDisabled = false;
        this.accountNumber = new AccountNumberGenerator(user).getAccountNumber();

    }
    @Builder
    public Account(@NonNull Long balance, @NonNull User user) {
        this.user = user;
        this.balance = balance;
        this.accountStatus = AccountStatus.ACTIVE;
        this.isLocked = false;
        this.isDisabled = false;
        this.accountNumber = new AccountNumberGenerator(user).getAccountNumber();

    }
    @Builder
    public Account(@NonNull User user, Long accountNumber) {
        this.user = user;
        this.balance = 0L;
        this.accountStatus = AccountStatus.ACTIVE;
        this.isLocked = false;
        this.isDisabled = true;
        this.accountNumber = accountNumber;

    }

    public Account() {

    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountType=" + accountType +
                ", balance=" + balance +
//                ", user=" + user +
                ", transactionList=" + transactionList +
                ", accountStatus=" + accountStatus +
                ", isLocked=" + isLocked +
                ", isDisabled=" + isDisabled +
                '}';
    }
}
