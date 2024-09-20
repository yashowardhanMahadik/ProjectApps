package com.ym.reddit1.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e){
        ErrorResponse errorResponse = new ErrorResponse(500,e.getMessage()+ " zzz "
        + Arrays.stream(e.getStackTrace()).map(StackTraceElement::toString).collect(Collectors.toList()));

        return ResponseEntity.status(501).body(errorResponse);
    }
}
