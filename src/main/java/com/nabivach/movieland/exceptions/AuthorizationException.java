package com.nabivach.movieland.exceptions;

public class AuthorizationException extends Exception{
    //costructor parameterless
    public AuthorizationException() {
    }
    //constructor with parameters
    public AuthorizationException(String message) {
        super(message);
    }
}
