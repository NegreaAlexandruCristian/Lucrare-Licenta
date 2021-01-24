package com.webgisapplicationclientrepository.controller;

import com.webgisapplicationclientrepository.model.User;
import com.webgisapplicationclientrepository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/location")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/",""})
    public ResponseEntity<User> getUserCurrentLocation(){
        return new ResponseEntity<>(userService.getUserLocation(), HttpStatus.OK);

    }
}
