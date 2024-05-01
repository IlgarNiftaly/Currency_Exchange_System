package com.binary.uniTech.entity;

import com.binary.uniTech.validation.EmailValid;
import com.binary.uniTech.validation.FinValid;
import com.binary.uniTech.validation.InfoValid;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoValid
    private String userName;

    @FinValid
    private String userPin;

    @EmailValid
    private String email;

    @InfoValid
    private String password;

    private Boolean emailVerified;

    private Long fkAccountId;

}
