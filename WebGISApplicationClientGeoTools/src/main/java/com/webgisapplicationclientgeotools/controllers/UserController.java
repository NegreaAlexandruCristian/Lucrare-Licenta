package com.webgisapplicationclientgeotools.controllers;

import com.webgisapplicationclientgeotools.models.Institution;
import com.webgisapplicationclientgeotools.models.ObjectWrapper;
import com.webgisapplicationclientgeotools.models.Point;
import com.webgisapplicationclientgeotools.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/user/location/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping("/distance")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    public BigDecimal calculateDistanceBetweenTwoPoints(@RequestBody ObjectWrapper objectWrapper){
        return userService.calculateDistanceBetweenTwoPoints(objectWrapper);
    }

    @ResponseBody
    @PostMapping("/zone")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    public List<Institution> getSpecificLocationsFromZone(@RequestBody Point point){
        return userService.getLocationsFromZone(point);
    }

    @ResponseBody
    @PostMapping("/shortest")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    public Institution getShortestLocationFromZone(@RequestBody Point point){
        return userService.getShortestLocationFromZone(point);
    }
}
