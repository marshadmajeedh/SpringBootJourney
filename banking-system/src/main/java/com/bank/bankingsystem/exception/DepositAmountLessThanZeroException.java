package com.bank.bankingsystem.exception;

public class DepositAmountLessThanZeroException extends RuntimeException {
    public DepositAmountLessThanZeroException(String message) {
        super(message);
    }
}
