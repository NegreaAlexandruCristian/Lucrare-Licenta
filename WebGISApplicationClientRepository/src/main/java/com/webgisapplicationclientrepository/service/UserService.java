package com.webgisapplicationclientrepository.service;

import com.webgisapplicationclientrepository.model.util.Institution;
import com.webgisapplicationclientrepository.model.util.ObjectWrapper;
import com.webgisapplicationclientrepository.model.util.Point;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    BigDecimal calculateDistance(ObjectWrapper objectWrapper);

    List<Institution> getLocationsFromZone(Point point);

    List<Institution> getAllLocationsFromZone(Point point);

    Institution getShortestLocationFromZone(Point point);
}
