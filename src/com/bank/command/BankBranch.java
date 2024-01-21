package com.bank.command;

import com.bank.entity.BankTeller;

import java.util.ArrayList;
import java.util.List;

public class BankBranch implements IBankBranch {
    private String address;
    private int cashOnHand;
    private IBankSystem bankSystem;
    private List<BankTeller> tellers;

    public BankBranch(String address, int cashOnHand, IBankSystem bankSystem) {
        this.address = address;
        this.cashOnHand = cashOnHand;
        this.bankSystem = bankSystem;
        this.tellers = new ArrayList<>();
    }

    public void addTeller(BankTeller teller) {
        this.tellers.add(teller);
    }

    //Returning any teller randomly
    private BankTeller getAvailableTeller() {
        int index = (int) Math.round(Math.random() * (this.tellers.size() - 1));
        return this.tellers.get(index);
    }


    public int openAccount(String customerName) {
        if (this.tellers.size() == 0) {
            throw new Error("Branch does not have any tellers");
        }
        BankTeller teller = this.getAvailableTeller();
        return this.bankSystem.openAccount(customerName, teller.getId());
    }

    public void deposit(int customerId, int amount) {
        if (this.tellers.size() == 0) {
            throw new Error("Branch does not have any tellers");
        }
        this.cashOnHand+=amount;
        BankTeller teller = this.getAvailableTeller();
        this.bankSystem.deposit(customerId, teller.getId(), amount);
    }
    public void withdraw(int customerId, int amount) {
        if (amount > this.cashOnHand) {
            throw new Error("Branch does not have enough cash");
        }
        if (this.tellers.size() == 0) {
            throw new Error("Branch does not have any tellers");
        }
        this.cashOnHand -= amount;
        BankTeller teller = this.getAvailableTeller();
        this.bankSystem.withdraw(customerId, teller.getId(), amount);
    }

    public int collectCash(double ratio) {
        int cashToCollect = (int) Math.round(this.cashOnHand * ratio);
        this.cashOnHand -= cashToCollect;
        return cashToCollect;
    }

    public void provideCash(int amount) {
        this.cashOnHand += amount;
    }
}

