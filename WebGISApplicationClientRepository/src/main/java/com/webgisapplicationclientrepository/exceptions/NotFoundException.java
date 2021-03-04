package com.webgisapplicationclientrepository.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Object not found");
    }
}