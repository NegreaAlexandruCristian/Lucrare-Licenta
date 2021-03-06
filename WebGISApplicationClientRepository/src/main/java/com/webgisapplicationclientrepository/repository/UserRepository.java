package com.webgisapplicationclientrepository.repository;

import com.webgisapplicationclientrepository.model.util.Institution;
import com.webgisapplicationclientrepository.model.util.Point;

import java.math.BigDecimal;
import java.util.List;

public interface UserRepository{

    BigDecimal calculateDistance(BigDecimal fromLatitude, BigDecimal fromLongitude,
                             BigDecimal toLatitude, BigDecimal toLongitude);

    List<Institution> getLocationsFromZone(BigDecimal latitude, BigDecimal longitude,
                                           String code, Long radius);

    Institution getShortestLocationFromZone(Point point);
}
