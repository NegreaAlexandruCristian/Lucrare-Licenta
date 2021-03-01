package com.webgisapplicationclientrepository.controller;

import com.webgisapplicationclientrepository.model.util.Institution;
import com.webgisapplicationclientrepository.model.util.ObjectWrapper;
import com.webgisapplicationclientrepository.model.util.Point;
import com.webgisapplicationclientrepository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(value = HttpStatus.OK)
    //requestBody = @RequestBody(required = true, content = @Content(mediaType = "JSON")
    public Number calculateDistance(@RequestBody ObjectWrapper objectWrapper){
        return userService.calculateDistance(objectWrapper);
    }

    @PostMapping("/zone")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Institution> getSpecificLocationsFromZone(@RequestBody Point point){
        return userService.getLocationsFromZone(point);
    }

    @PostMapping("/all")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Institution> getAllLocationsFromZone(@RequestBody Point point){
        return userService.getAllLocationsFromZone(point);
    }

    @PostMapping("/shortest")
    @ResponseStatus(value = HttpStatus.OK)
    public Institution getShortestLocationFromZone(@RequestBody Point point){
        return userService.getShortestLocationFromZone(point);
    }

}
