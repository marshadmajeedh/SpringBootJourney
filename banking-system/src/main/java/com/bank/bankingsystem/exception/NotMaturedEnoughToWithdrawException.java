package com.bank.bankingsystem.exception;

public class NotMaturedEnoughToWithdrawException extends RuntimeException {
    public NotMaturedEnoughToWithdrawException(String message) {
        super(message);
    }
}
