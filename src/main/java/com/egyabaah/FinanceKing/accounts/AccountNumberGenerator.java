package com.egyabaah.FinanceKing.accounts;

import com.egyabaah.FinanceKing.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class AccountNumberGenerator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final Long accountNumber = 6030272890L;
// Can be omitted but can also serve as back up  when accounts table is tempered
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public AccountNumberGenerator(User user){

//        this.accountNumber++;
        this.user = user;
    }

    public AccountNumberGenerator() {

    }

    /**
     * Generates account number
     * @return Long - Sum of id and predefined account initials
     */
    public Long getAccountNumber() {
        return accountNumber + this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
