package com.bank.dto;

public class DepositOperation extends BankOperation {
    private int amount;

    // TODO: Can include account id in case of multiple accounts for a single customer

    public DepositOperation(int customerId, int tellerId, int amount) {
        super(customerId, tellerId);
        this.amount = amount;
    }

    @Override
    public String getBankOperation() {
        return "Teller " + getTellerId() + " deposited " + amount + " to account " + getCustomerId();
    }
}

// DTO - Data transfer Object

// deposit - customer id, teller id, amount