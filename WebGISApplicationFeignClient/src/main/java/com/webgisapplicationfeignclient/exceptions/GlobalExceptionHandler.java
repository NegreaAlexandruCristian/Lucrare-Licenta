package com.webgisapplicationfeignclient.exceptions;

import feign.FeignException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public Throwable handleFeignStatusException(FeignException feignException, HttpServletResponse response) {
        response.setStatus(feignException.status());
        return feignException.getCause();
    }
}