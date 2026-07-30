package com.bank.bankingsystem.exception;

public class WithdrawAmountGreaterThanBalanceException extends RuntimeException {
    public WithdrawAmountGreaterThanBalanceException(String message) {
        super(message);
    }
}
