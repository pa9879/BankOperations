package com.bank.command;

import com.bank.entity.BankTeller;

public interface IBankBranch {
    public void addTeller(BankTeller teller);

    public int openAccount(String customerName);

    public void deposit(int customerId, int amount);
    public void withdraw(int customerId, int amount);

    public int collectCash(double ratio);

    public void provideCash(int amount);
}
