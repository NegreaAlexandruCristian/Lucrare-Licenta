package com.webgisapplicationclientrepository.service.implementation;

import com.webgisapplicationclientrepository.model.util.Institution;
import com.webgisapplicationclientrepository.model.util.ObjectWrapper;
import com.webgisapplicationclientrepository.model.util.Point;
import com.webgisapplicationclientrepository.repository.UserRepository;
import com.webgisapplicationclientrepository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Number calculateDistance(ObjectWrapper objectWrapper) {

        Point fromDistance = objectWrapper.getFromDistance();
        Point toDistance = objectWrapper.getToDistance();
        return userRepository.calculateDistance(fromDistance.getLatitude(), fromDistance.getLongitude(),
                toDistance.getLatitude(), toDistance.getLongitude());
    }

    @Override
    public List<Institution> getLocationsFromZone(Point point){
        return userRepository.getLocationsFromZone(point.getLatitude(), point.getLongitude(),
                point.getCode(),point.getRadius());
    }

}
