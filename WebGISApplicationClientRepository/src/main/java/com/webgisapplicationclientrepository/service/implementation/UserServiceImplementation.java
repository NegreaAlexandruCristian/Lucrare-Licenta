package com.webgisapplicationclientrepository.service.implementation;

import com.webgisapplicationclientrepository.exceptions.utils.ConstraintViolationExceptionCustom;
import com.webgisapplicationclientrepository.exceptions.utils.NotAllowedException;
import com.webgisapplicationclientrepository.model.util.Institution;
import com.webgisapplicationclientrepository.model.util.ObjectWrapper;
import com.webgisapplicationclientrepository.model.util.Point;
import com.webgisapplicationclientrepository.repository.UserRepository;
import com.webgisapplicationclientrepository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final String[] tableNames = new String []{
            "buss_stations", "hospital","pharmacy", "schools", "university"
    };
    private final Map<Integer,String> types = Map.ofEntries(
            Map.entry(1,"hospital"),
            Map.entry(2,"buss_stations"),
            Map.entry(3,"pharmacy"),
            Map.entry(4,"schools"),
            Map.entry(5,"university")
    );

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private boolean checkConstraints(Point fromDistance, Point toDistance) {
        if(fromDistance.getLongitude() == null || fromDistance.getLatitude() == null){
            return false;
        } else return toDistance.getLongitude() != null && toDistance.getLatitude() != null;
    }

    @Override
    public BigDecimal calculateDistance(ObjectWrapper objectWrapper) {

        Point fromDistance = objectWrapper.getStartingDistance();
        Point toDistance = objectWrapper.getFinishDestination();
        if (checkConstraints(fromDistance, toDistance)) {
            return userRepository.calculateDistance(fromDistance.getLatitude(), fromDistance.getLongitude(),
                    toDistance.getLatitude(), toDistance.getLongitude());
        } else {
            throw new ConstraintViolationExceptionCustom();
        }
    }

    @Override
    public List<Institution> getLocationsFromZone(Point point){
        final String code = point.getCode().toLowerCase();
        if(types.containsValue(code)){
            return userRepository.getLocationsFromZone(point.getLatitude(), point.getLongitude(),
                    point.getCode(),point.getRadius());
        } else {
            throw new NotAllowedException();
        }
    }

    @Override
    public List<Institution> getAllLocationsFromZone(Point point) {
        List<Institution> institutionList = new ArrayList<>();
        for(String tableName: tableNames){
            institutionList.addAll(userRepository.getLocationsFromZone(point.getLatitude(), point.getLongitude(),
                    tableName,point.getRadius()));
        }
        return institutionList;
    }

    @Override
    public Institution getShortestLocationFromZone(Point point){
        final String code = point.getCode().toLowerCase();
        if(types.containsValue(code)){
            return userRepository.getShortestLocationFromZone(point);
        } else {
            throw new NotAllowedException();
        }
    }
}
