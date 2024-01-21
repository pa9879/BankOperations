package com.bank.command;

import com.bank.dto.BankOperation;
import com.bank.entity.BankAccount;

import java.util.List;

public interface IBankSystem {
    public BankAccount getAccount(int customerId);

    public List<BankAccount> getAccounts();

    public List<BankOperation> getBankOperations();

    public int openAccount(String customerName, int tellerId);

    public void deposit(int customerId, int tellerId, int amount);

    public void withdraw(int customerId, int tellerId, int amount);
}
