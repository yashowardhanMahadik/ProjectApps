package com.ym.reddit2.Exception;

import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<?> handleException(DuplicateKeyException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate key");
    }
    @ExceptionHandler(MongoWriteException.class)
    public ResponseEntity<?> handleWriteException(MongoWriteException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(" comment already exists for this post by user");
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<?> handlePostNotFoundException(PostNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()+" PostId does not exist, please enter valid postId");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllExceptions(Exception e){
        ErrorResponse errorResponse = new ErrorResponse(500,e.getMessage()+"zzz "+ Arrays.stream(e.getStackTrace())
                .map(StackTraceElement::toString)
//                .reduce("",(curr,res)-> curr+"-> \n "+res)
                .collect(Collectors.toList())
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
 }
