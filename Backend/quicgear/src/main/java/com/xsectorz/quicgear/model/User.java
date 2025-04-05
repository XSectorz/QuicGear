package com.xsectorz.quicgear.model;

import com.xsectorz.quicgear.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String emailID;

    @Column(name = "balance")
    private double balance = 0;

    public User() {

    }

    public User(UserRole userRole, String firstName, String lastName, String emailID, double balance) {
        this.userRole = userRole;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.balance = balance;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }
    
    public UserRole getUserRole() {
        return userRole;
    }
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
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
    public String getEmailID() {
        return emailID;
    }
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }


}
