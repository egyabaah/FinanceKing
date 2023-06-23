//package com.egyabaah.FinanceKing.transaction;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.time.LocalDateTime;
//
///**
// * @author gyabe
// *
// */
//@Entity
//@Table(name="transactions")
//@Data
////@AllArgsConstructor
//public class Transactions {
//	// Fields
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
////	private Long userid;
//	@Enumerated(EnumType.STRING)
//	private TransactionType transactionType;
//	private Long from;
//	private Long to;
//	private Long amount;
//	private String transactionNumber;
//	private String transactionNote;
//	@Enumerated(EnumType.STRING)
//	private TransactionMethod transactionMethod;
//	private LocalDateTime transactionTime;
//	@Enumerated(EnumType.STRING)
//	private TransactionStatus transactionStatus;
////	@ManyToOne
////	@JoinColumn(name="account_id")
////	public Account account;
//
//	public Transactionsjkl(TransactionType transactionType, Long from, Long to, Long amount, String transactionNumber, String transactionNote, TransactionMethod transactionMethod, LocalDateTime transactionTime, TransactionStatus transactionStatus) {
//		this.transactionType = transactionType;
//		this.from = from;
//		this.to = to;
//		this.amount = amount;
//		this.transactionNumber = transactionNumber;
//		this.transactionNote = transactionNote;
//		this.transactionMethod = transactionMethod;
//		this.transactionTime = transactionTime;
//		this.transactionStatus = transactionStatus;
////		this.account = account;
//	}
//}
