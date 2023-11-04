package com.henriquegc.picpaychallenge.domain.user;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private BigDecimal amount;

    public User() {
        this.email = "";
        this.userType = UserType.COMMON;
        this.password = "";
        this.firstName = "";
        this.lastName = "";
        this.document = "";
        this.amount = new BigDecimal(0);
    }

    public User(String email, UserType userType, String password, String firstName, String lastName, String document, BigDecimal amount) {
        this.email = email;
        this.userType = userType;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
