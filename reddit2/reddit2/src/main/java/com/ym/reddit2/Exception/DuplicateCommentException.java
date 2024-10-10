package com.ym.reddit2.Exception;

public class DuplicateCommentException extends RuntimeException{
    public DuplicateCommentException(String message){
        super(message);
    }
}
