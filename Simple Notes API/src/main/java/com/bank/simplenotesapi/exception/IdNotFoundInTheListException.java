package com.bank.simplenotesapi.exception;

public class IdNotFoundInTheListException extends RuntimeException {
    public IdNotFoundInTheListException(String message) {
        super(message);
    }
}
