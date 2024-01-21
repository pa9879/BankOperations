package com.bank.exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(int customerId) {
        super("Insufficient Balance for customer " + customerId);
    }
}
