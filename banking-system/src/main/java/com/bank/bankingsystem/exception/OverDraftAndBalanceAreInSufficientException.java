package com.bank.bankingsystem.exception;

public class OverDraftAndBalanceAreInSufficientException extends RuntimeException {
    public OverDraftAndBalanceAreInSufficientException(String message) {
        super(message);
    }
}
