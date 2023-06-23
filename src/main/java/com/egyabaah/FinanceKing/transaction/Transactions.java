package com.egyabaah.FinanceKing.transaction;

import com.egyabaah.FinanceKing.accounts.Account;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name="transactions")
@Table(name="transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
public class Transactions {
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private Long fromAccount;
    private Long toAccount;
    private Long amount;
    private String transactionNumber;
    private String transactionNote;
    @Enumerated(EnumType.STRING)
    private TransactionMethod transactionMethod;
    private LocalDateTime transactionTime;
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;
	@ManyToOne
	@JoinColumn(name="account_id")
	public Account account;

    public Transactions(Account account){
        this.account = account;
        this.transactionTime = LocalDateTime.now();
    }
    @Override
    public String toString() {
        return "Transactions{" +
                "id=" + id +
                ", transactionType=" + transactionType +
                ", fromAccount=" + fromAccount +
                ", toAssccount=" + toAccount +
                ", amount=" + amount +
                ", transactionNumber='" + transactionNumber + '\'' +
                ", transactionNote='" + transactionNote + '\'' +
                ", transactionMethod=" + transactionMethod +
                ", transactionTime=" + transactionTime +
                ", transactionStatus=" + transactionStatus +
//                ", account=" + account +
                '}';
    }
}
