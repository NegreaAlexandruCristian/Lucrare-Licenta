package com.webgisapplicationclientrepository.controller;

import com.webgisapplicationclientrepository.model.util.Institution;
import com.webgisapplicationclientrepository.model.util.ObjectWrapper;
import com.webgisapplicationclientrepository.model.util.Point;
import com.webgisapplicationclientrepository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/location")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/distance")
    public Number calculateDistance(@RequestBody ObjectWrapper objectWrapper){
        return userService.calculateDistance(objectWrapper);
    }

    @PostMapping("/zone")
    public List<Institution> getSpecificLocationsFromZone(@RequestBody Point point){
        return userService.getLocationsFromZone(point);
    }

    @PostMapping("/all")
    public List<Institution> getAllLocationsFromZone(@RequestBody Point point){
        return userService.getAllLocationsFromZone(point);
    }

    @PostMapping("/shortest")
    public Institution getShortestLocationFromZone(@RequestBody Point point){
        return userService.getShortestLocationFromZone(point);
    }

}
