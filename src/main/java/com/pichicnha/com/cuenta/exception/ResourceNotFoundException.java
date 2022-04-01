package com.pichicnha.com.cuenta.exception;

public class  ResourceNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException (String message) {
        super(message);
    }
}
