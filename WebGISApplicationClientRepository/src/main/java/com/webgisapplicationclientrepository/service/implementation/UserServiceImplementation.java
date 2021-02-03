package com.webgisapplicationclientrepository.service.implementation;

import com.webgisapplicationclientrepository.model.util.Institution;
import com.webgisapplicationclientrepository.model.util.ObjectWrapper;
import com.webgisapplicationclientrepository.model.util.Point;
import com.webgisapplicationclientrepository.model.util.ZoneWrapper;
import com.webgisapplicationclientrepository.repository.UserRepository;
import com.webgisapplicationclientrepository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public BigDecimal getDistance(ObjectWrapper objectWrapper) {

        Point fromDistance = objectWrapper.getFromDistance();
        Point toDistance = objectWrapper.getToDistance();
        return userRepository.getDistance(fromDistance.getLatitude(), fromDistance.getLongitude(),
                toDistance.getLatitude(), toDistance.getLongitude());
    }

    @Override
    public Institution getLocationsFromZone(ZoneWrapper zoneWrapper) {
        Point point = zoneWrapper.getPoint();
        Institution institution = zoneWrapper.getInstitution();
        return userRepository.getLocationsFromZone(point.getLatitude(), point.getLongitude(),
                institution.getCode(),10);
    }

}
