package com.bank.simpleaskmanagerapi.exception;

import com.bank.simpleaskmanagerapi.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TitleNotMatchException.class)
    public ResponseEntity<ErrorResponse> handleTitleNotMatchException(TitleNotMatchException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(),HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
