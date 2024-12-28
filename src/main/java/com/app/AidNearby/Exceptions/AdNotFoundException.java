package com.app.AidNearby.Exceptions;

public class AdNotFoundException extends RuntimeException {
    //status code 404
    public AdNotFoundException(String message) {
        super(message);
    }
}