package com.app.AidNearby.Exceptions;

public class InvalidCredentialsException extends RuntimeException {
    //status code 400
    public InvalidCredentialsException(String message) {
        super(message);
    }
}