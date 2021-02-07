package com.webgisapplicationclientgeotools.services.implementation;

import com.webgisapplicationclientgeotools.geotools.UserGeoTools;
import com.webgisapplicationclientgeotools.models.ObjectWrapper;
import com.webgisapplicationclientgeotools.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImplementation implements UserService {

    private final UserGeoTools userGeoTools;

    @Autowired
    public UserServiceImplementation(UserGeoTools userGeoTools) {
        this.userGeoTools = userGeoTools;
    }

    @Override
    public BigDecimal calculateDistanceBetweenTwoPoints(ObjectWrapper objectWrapper) {
        return userGeoTools.calculateDistanceBetweenTwoPoints(objectWrapper);
    }
}
