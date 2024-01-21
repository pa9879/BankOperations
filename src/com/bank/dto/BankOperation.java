package com.bank.dto;

public class BankOperation {
    private int customerId;
    private int tellerId;

    public BankOperation(int customerId, int tellerId) {
        this.customerId = customerId;
        this.tellerId = tellerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getTellerId() {
        return tellerId;
    }

    public String getBankOperation() {
        return "";
    }
}
