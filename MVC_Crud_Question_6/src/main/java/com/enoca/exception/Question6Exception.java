package com.enoca.exception;

import lombok.Getter;

@Getter
public class Question6Exception extends RuntimeException{

    private final ErrorType errorType;

    public Question6Exception(ErrorType errorType, String customMessage) {
        super(customMessage);
        this.errorType = errorType;
    }

    public Question6Exception(ErrorType errorType){
        this.errorType = errorType;
    }
}
