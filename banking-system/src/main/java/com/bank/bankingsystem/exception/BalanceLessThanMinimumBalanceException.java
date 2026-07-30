package com.bank.bankingsystem.exception;

public class BalanceLessThanMinimumBalanceException extends RuntimeException {
    public BalanceLessThanMinimumBalanceException (String message) {
        super(message);
    }
}
