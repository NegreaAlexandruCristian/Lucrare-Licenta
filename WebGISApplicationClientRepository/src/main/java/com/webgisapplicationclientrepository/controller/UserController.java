package com.webgisapplicationclientrepository.controller;

import com.webgisapplicationclientrepository.model.util.Institution;
import com.webgisapplicationclientrepository.model.util.ObjectWrapper;
import com.webgisapplicationclientrepository.model.util.ZoneWrapper;
import com.webgisapplicationclientrepository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/user/location")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/distance")
    public BigDecimal calculateDistance(@RequestBody ObjectWrapper objectWrapper){
        return userService.getDistance(objectWrapper);
    }

    @PostMapping("/zone")
    public Institution getLocationsFromZone(@RequestBody ZoneWrapper zoneWrapper){
        return userService.getLocationsFromZone(zoneWrapper);
    }
}
