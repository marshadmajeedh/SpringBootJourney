package com.bank.bankingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.bank.bankingsystem.dto.ErrorResponse;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WithdrawAmountGreaterThanBalanceException.class)
    public ResponseEntity<ErrorResponse> handleInsufficientBalanceException(WithdrawAmountGreaterThanBalanceException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BalanceLessThanMinimumBalanceException.class)
    public ResponseEntity<ErrorResponse>handleBalanceLessThanMinimumBalanceException(BalanceLessThanMinimumBalanceException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(DepositAmountLessThanZeroException.class)
    public ResponseEntity<ErrorResponse>HandledDepositAmountLessThanZeroException(DepositAmountLessThanZeroException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotMaturedEnoughToWithdrawException.class)
    public ResponseEntity<ErrorResponse>handleNotMaturedEnoughToWithdrawException(NotMaturedEnoughToWithdrawException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OverDraftAmountIsInSufficientException.class)
    public ResponseEntity<ErrorResponse>handleOverOverDraftAmountIsInSufficientException(OverDraftAmountIsInSufficientException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OverDraftAndBalanceAreInSufficientException.class)
    public ResponseEntity<ErrorResponse>handleOverDraftAndBalanceAreInSufficientException(OverDraftAndBalanceAreInSufficientException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
