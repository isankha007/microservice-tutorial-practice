package com.sankha.hotel.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        super("Resource not Found");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
