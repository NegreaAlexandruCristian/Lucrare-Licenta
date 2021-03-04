package com.webgisapplicationclientrepository.service.implementation;

import com.webgisapplicationclientrepository.exceptions.ConstraintViolationExceptionCustom;
import com.webgisapplicationclientrepository.model.util.Institution;
import com.webgisapplicationclientrepository.model.util.ObjectWrapper;
import com.webgisapplicationclientrepository.model.util.Point;
import com.webgisapplicationclientrepository.repository.UserRepository;
import com.webgisapplicationclientrepository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final String[] tableNames = new String []{
            "buss_stations", "hospital","pharmacy", "schools", "university"
    };

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
    public Number calculateDistance(ObjectWrapper objectWrapper) {

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
        return userRepository.getLocationsFromZone(point.getLatitude(), point.getLongitude(),
                point.getCode(),point.getRadius());
    }

    @Override
    public List<Institution> getAllLocationsFromZone(Point point) {
        List<Institution> institutionList = new ArrayList<>();
        System.out.println("HERE");
        for(String tableName: tableNames){
            System.out.println(userRepository.getLocationsFromZone(point.getLatitude(), point.getLongitude(),
                    tableName,point.getRadius()));
            institutionList.addAll(userRepository.getLocationsFromZone(point.getLatitude(), point.getLongitude(),
                    tableName,point.getRadius()));
        }
        return institutionList;
    }

    @Override
    public Institution getShortestLocationFromZone(Point point){
        return userRepository.getShortestLocationFromZone(point);
    }

}
