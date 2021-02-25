package com.webgisapplicationclientrepository.service.implementation;

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
    private final String tableNames[] = new String []{
            "buss_stations", "hospital","pharmacy", "schools", "university"
    };

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Number calculateDistance(ObjectWrapper objectWrapper) {

        Point fromDistance = objectWrapper.getStartingDistance();
        Point toDistance = objectWrapper.getFinishDestination();
        System.out.println(toDistance);
        System.out.println(fromDistance);
        return userRepository.calculateDistance(fromDistance.getLatitude(), fromDistance.getLongitude(),
                toDistance.getLatitude(), toDistance.getLongitude());
    }

    @Override
    public List<Institution> getLocationsFromZone(Point point){
        return userRepository.getLocationsFromZone(point.getLatitude(), point.getLongitude(),
                point.getCode(),point.getRadius());
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
        return userRepository.getShortestLocationFromZone(point);
    }

}
