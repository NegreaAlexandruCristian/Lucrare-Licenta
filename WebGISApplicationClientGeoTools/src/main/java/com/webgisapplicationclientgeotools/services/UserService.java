package com.webgisapplicationclientgeotools.services;

import com.webgisapplicationclientgeotools.models.Institution;
import com.webgisapplicationclientgeotools.models.ObjectWrapper;
import com.webgisapplicationclientgeotools.models.Point;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {
    BigDecimal calculateDistanceBetweenTwoPoints(ObjectWrapper objectWrapper);

    List<Institution> getLocationsFromZone(Point point);
}