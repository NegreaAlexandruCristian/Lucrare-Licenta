package com.webgisapplicationclientrepository.exceptions;

public class ConstraintViolationExceptionCustom extends RuntimeException {
    public ConstraintViolationExceptionCustom(){
        super("Bad Object Request.");
    }
}
