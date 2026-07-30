package com.bank.bankingsystem.exception;

public class OverDraftAmountIsInSufficientException extends RuntimeException {
    public OverDraftAmountIsInSufficientException(String message) {
        super(message);
    }
}
