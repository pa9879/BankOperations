package com.bank.entity;

public class BankAccount {
    private int customerId;
    private String name;
    private int balance;

    public BankAccount(int customerId, String name, int balance) {
        this.customerId = customerId;
        this.name = name;
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }
}
