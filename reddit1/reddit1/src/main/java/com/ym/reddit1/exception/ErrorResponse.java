package com.ym.reddit1.exception;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
public class ErrorResponse {
    private final int errorCode;
    private final String msg;
    public ErrorResponse(int errorCode,String msg){
        this.errorCode = errorCode;
        this.msg = msg;
    }
}
