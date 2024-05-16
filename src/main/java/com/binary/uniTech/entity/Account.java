package com.binary.uniTech.entity;


import com.binary.uniTech.validation.AccountNumberValid;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @AccountNumberValid
    @Column(name = "account_number")
    private String accountNumber;


    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "fk_user_id")
    private Long fkUserId;

    @Column(name = "status")
    private String status;

    @PrePersist
    public void prePersist(){
        if(status == null){
            status = "A";
        }
    }

}
