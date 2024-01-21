package com.bank.command;

import com.bank.dto.BankOperation;
import com.bank.dto.DepositOperation;
import com.bank.dto.OpenAccountOperation;
import com.bank.dto.WithdrawalOperation;
import com.bank.entity.*;
import com.bank.exception.AccountNotFound;
import com.bank.exception.InsufficientBalanceException;

import java.util.*;

public class BankSystem implements IBankSystem {
    private Map<Integer, BankAccount> accountMap;
    private List<BankOperation> bankOperations;

    public BankSystem() {
        this.accountMap = new HashMap<>();
        this.bankOperations = new ArrayList<>();
    }

    public BankAccount getAccount(int customerId) {
        return this.accountMap.get(customerId);
    }

    public List<BankAccount> getAccounts() {
        return this.accountMap.values().stream().toList();
    }

    public List<BankOperation> getBankOperations() {
        return this.bankOperations;
    }

    public int openAccount(String customerName, int tellerId) {

        // Create account
        int customerId = this.accountMap.size();
        BankAccount account = new BankAccount(customerId, customerName, 0);
        this.accountMap.put(customerId, account);

        // Log bank operation
        BankOperation bankOperation = new OpenAccountOperation(customerId, tellerId);
        this.bankOperations.add(bankOperation);
        return customerId;
    }

    public void deposit(int customerId, int tellerId, int amount) {
        BankAccount account = this.getAccount(customerId);
        if(Objects.isNull(account))
            throw new AccountNotFound("Account Not found for Deposit");

        account.deposit(amount);

        // Log Deposit Operation
        BankOperation bankOperation = new DepositOperation(customerId, tellerId, amount);
        this.bankOperations.add(bankOperation);
    }

    public void withdraw(int customerId, int tellerId, int amount) throws InsufficientBalanceException {
        BankAccount account = this.getAccount(customerId);
        if(Objects.isNull(account))
            throw new AccountNotFound("Account Not found for withdrawal");

        if (amount > account.getBalance()) {
            throw new InsufficientBalanceException(customerId);
        }
        account.withdraw(amount);

        //Log Operation
        BankOperation transaction = new WithdrawalOperation(customerId, tellerId, amount);
        this.bankOperations.add(transaction);
    }
}






