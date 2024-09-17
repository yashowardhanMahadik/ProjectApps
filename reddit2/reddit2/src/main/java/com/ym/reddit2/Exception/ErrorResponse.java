package com.ym.reddit2.Exception;

public class ErrorResponse {
    private final int errorCode;
    private final String errorMessage;

    public ErrorResponse(int code,String msg){
        this.errorCode = code;
        this.errorMessage = msg;
    }
    public int getErrorCode(){return errorCode;}
    public String getErrorMessage(){return errorMessage;}
}
