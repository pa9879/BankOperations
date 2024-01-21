package com.bank.dto;

public class WithdrawalOperation extends BankOperation {
    private int amount;

    public WithdrawalOperation(int customerId, int tellerId, int amount) {
        super(customerId, tellerId);
        this.amount = amount;
    }

    @Override
    public String getBankOperation() {
        return "Teller " + getTellerId() + " withdrew " + amount + " from account " + getCustomerId();
    }
}
