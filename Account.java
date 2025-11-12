package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    private int accountId;
    private String owner;
    private double balance;

    public Account() {}
    public Account(int accountId, String owner, double balance) {
        this.accountId = accountId;
        this.owner = owner;
        this.balance = balance;
    }

    public int getAccountId() { return accountId; }
    public String getOwner() { return owner; }
    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }
}
