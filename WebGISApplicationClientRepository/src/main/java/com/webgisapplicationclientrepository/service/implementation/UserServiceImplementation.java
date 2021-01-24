package com.webgisapplicationclientrepository.service.implementation;

import com.webgisapplicationclientrepository.model.User;
import com.webgisapplicationclientrepository.repository.UserRepository;
import com.webgisapplicationclientrepository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserLocation() {
        return userRepository.getUserCurrentLocation();
    }
}
