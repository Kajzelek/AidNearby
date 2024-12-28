package com.app.AidNearby.Exceptions;

public class AdApplicationNotFoundException extends RuntimeException {
    //status code 404
    public AdApplicationNotFoundException(String message) {
        super(message);
    }
}