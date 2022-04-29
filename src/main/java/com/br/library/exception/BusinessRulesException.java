package com.br.library.exception;

public class BusinessRulesException extends RuntimeException{
    public BusinessRulesException(String message) {
        super(message);
    }

    public BusinessRulesException() {

    }
}