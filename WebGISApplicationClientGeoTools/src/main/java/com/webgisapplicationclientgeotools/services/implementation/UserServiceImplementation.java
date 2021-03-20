package com.webgisapplicationclientgeotools.services.implementation;

import com.webgisapplicationclientgeotools.dto.InstitutionDTO;
import com.webgisapplicationclientgeotools.exceptions.utils.ConstraintViolationExceptionCustom;
import com.webgisapplicationclientgeotools.exceptions.utils.NotAllowedException;
import com.webgisapplicationclientgeotools.geotools.UserGeoTools;
import com.webgisapplicationclientgeotools.mapper.InstitutionMapper;
import com.webgisapplicationclientgeotools.models.Institution;
import com.webgisapplicationclientgeotools.models.ObjectWrapper;
import com.webgisapplicationclientgeotools.models.Point;
import com.webgisapplicationclientgeotools.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    private final UserGeoTools userGeoTools;
    private final Map<Integer,String> types = Map.ofEntries(
            Map.entry(1,"hospital"),
            Map.entry(2,"buss_stations"),
            Map.entry(3,"pharmacy"),
            Map.entry(4,"schools"),
            Map.entry(5,"university")
    );
    private final InstitutionMapper institutionMapper;

    @Autowired
    public UserServiceImplementation(UserGeoTools userGeoTools, InstitutionMapper institutionMapper) {
        this.userGeoTools = userGeoTools;
        this.institutionMapper = institutionMapper;
    }

    private boolean checkConstraints(Point fromDistance, Point toDistance) {
        if(fromDistance.getLongitude() == null || fromDistance.getLatitude() == null){
            return false;
        } else return toDistance.getLongitude() != null && toDistance.getLatitude() != null;
    }

    @Override
    public BigDecimal calculateDistanceBetweenTwoPoints(ObjectWrapper objectWrapper) {
        Point fromDistance = objectWrapper.getStartingDistance();
        Point toDistance = objectWrapper.getFinishDestination();
        if (checkConstraints(fromDistance, toDistance)) {
            return userGeoTools.calculateDistanceBetweenTwoPoints(objectWrapper);

        } else {
            throw new ConstraintViolationExceptionCustom();
        }
    }

    @Override
    public List<InstitutionDTO> getLocationsFromZone(Point point) {
        final String code = point.getCode().toLowerCase();
        if(types.containsValue(code)) {
            return userGeoTools.getLocationsFromZone(point)
                    .stream()
                    .map(institutionMapper::institutionToInstitutionDTO)
                    .collect(Collectors.toList());
        } else {
            throw new NotAllowedException();
        }
    }

    @Override
    public InstitutionDTO getShortestLocationFromZone(Point point) {
        final String code = point.getCode().toLowerCase();
        if(types.containsValue(code)) {
            Institution institution = userGeoTools.getShortestLocationFromZone(point);
            return institutionMapper.institutionToInstitutionDTO(institution);
        } else {
            throw new NotAllowedException();
        }
    }
}
