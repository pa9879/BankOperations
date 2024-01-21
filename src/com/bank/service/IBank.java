package com.bank.service;

import com.bank.command.BankBranch;
import com.bank.dto.BankOperation;

public interface IBank {
    public BankBranch addBranch(String address, int initialFunds);

    public void collectCash(double ratio);

    public void printTransactions();
}
