package com.webgisapplicationfeignclientgeotools.exceptions.utils;

public class ConstraintViolationExceptionCustom extends RuntimeException {
    public ConstraintViolationExceptionCustom(){
        super("Bad Object Request.");
    }
}
