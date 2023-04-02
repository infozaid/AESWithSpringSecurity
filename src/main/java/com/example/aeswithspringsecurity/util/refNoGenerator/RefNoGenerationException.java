package com.example.aeswithspringsecurity.util.refNoGenerator;


public class RefNoGenerationException extends RuntimeException {
    public RefNoGenerationException(String message, Throwable ex) {
        super(message, ex);
    }
}