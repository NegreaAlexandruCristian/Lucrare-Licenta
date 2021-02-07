package com.webgisapplicationclientgeotools.controllers;

import com.webgisapplicationclientgeotools.models.ObjectWrapper;
import com.webgisapplicationclientgeotools.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping("/user/location/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/distance")
    public ResponseEntity<BigDecimal> calculateDistanceBetweenTwoPoints(@RequestBody ObjectWrapper objectWrapper){
        return new ResponseEntity<>(userService.calculateDistanceBetweenTwoPoints(objectWrapper), HttpStatus.OK);
    }
}
