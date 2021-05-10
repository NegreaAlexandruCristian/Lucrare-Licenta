package com.webgisapplicationclientrepository.service;

import com.webgisapplicationclientrepository.dto.InstitutionDTO;
import com.webgisapplicationclientrepository.model.util.ObjectWrapper;
import com.webgisapplicationclientrepository.model.util.Point;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    BigDecimal calculateDistance(ObjectWrapper objectWrapper);

    List<InstitutionDTO> getLocationsFromZone(Point point);

    List<InstitutionDTO> getAllLocationsFromZone(Point point);

    InstitutionDTO getShortestLocationFromZone(Point point);

    InstitutionDTO getLocationByName(String name);
}
