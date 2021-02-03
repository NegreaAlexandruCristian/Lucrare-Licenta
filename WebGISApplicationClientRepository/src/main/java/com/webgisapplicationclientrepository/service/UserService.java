package com.webgisapplicationclientrepository.service;

import com.webgisapplicationclientrepository.model.util.Institution;
import com.webgisapplicationclientrepository.model.util.ObjectWrapper;
import com.webgisapplicationclientrepository.model.util.ZoneWrapper;

import java.math.BigDecimal;

public interface UserService {

    BigDecimal getDistance(ObjectWrapper objectWrapper);

    Institution getLocationsFromZone(ZoneWrapper zoneWrapper);
}
