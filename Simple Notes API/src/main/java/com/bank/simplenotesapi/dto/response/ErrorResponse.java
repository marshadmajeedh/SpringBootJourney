package com.bank.simplenotesapi.dto.response;

public class ErrorResponse {
    private final String errorMessage;
    private final int statusCode;

    public ErrorResponse(String errorMessage, int statusCode) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
