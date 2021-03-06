package com.webgisapplicationclientgeotools.exceptions.utils;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Object not found");
    }
}