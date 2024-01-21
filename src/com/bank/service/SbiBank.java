package com.bank.service;

import com.bank.dto.BankOperation;
import com.bank.command.BankSystem;
import com.bank.command.BankBranch;

import java.util.ArrayList;
import java.util.List;

public class SbiBank implements IBank {
    private List<BankBranch> branches;
    private BankSystem bankSystem;
    private int totalCash;

    public SbiBank(BankSystem bankSystem, int totalCash) {
        this.branches = new ArrayList<>();
        this.bankSystem = bankSystem;
        this.totalCash = totalCash;
    }

    public BankBranch addBranch(String address, int initialFunds) {
        BankBranch branch = new BankBranch(address, initialFunds, this.bankSystem);
        this.branches.add(branch);
        return branch;
    }

    public void collectCash(double ratio) {
        for (BankBranch branch : this.branches) {
            int cashCollected = branch.collectCash(ratio);
            this.totalCash += cashCollected;
        }
    }

    public void printTransactions() {
        for (BankOperation bankOperation : this.bankSystem.getBankOperations()) {
            System.out.println(bankOperation.getBankOperation());
        }
    }
}

