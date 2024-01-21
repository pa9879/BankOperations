package com.bank.dto;

public class OpenAccountOperation extends BankOperation {
    public OpenAccountOperation(int customerId, int tellerId) {
        super(customerId, tellerId);
    }

    @Override
    public String getBankOperation() {
        return "Teller " + getTellerId() + " opened account " + getCustomerId();
    }
}
