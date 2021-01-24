package com.webgisapplicationclientrepository.repository.implementation;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.webgisapplicationclientrepository.model.User;
import com.webgisapplicationclientrepository.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Component
public class UserRepositoryImplementation implements UserRepository {

    private final DatabaseReader dbReader;

    @Autowired
    public UserRepositoryImplementation(ResourceLoader resourceLoader) throws IOException {
        Resource resource= resourceLoader.getResource("classpath:static/database/GeoLite2-City.mmdb");
        File database = resource.getFile();
        dbReader = new DatabaseReader.Builder(database).build();
    }

    @Override
    public User getUserCurrentLocation() {

        try{
            final String uri = "https://api.ipify.org";
            RestTemplate restTemplate = new RestTemplate();
            String ip = restTemplate.getForObject(uri, String.class);

            InetAddress ipAddress = InetAddress.getByName(ip);
            CityResponse response = dbReader.city(ipAddress);

            String cityName = response.getCity().getName();
            double latitude =
                    response.getLocation().getLatitude();
            double longitude =
                    response.getLocation().getLongitude();
            return new User(ip, cityName, latitude, longitude);

        } catch (Exception e){
            e.printStackTrace();
        }
       return new User();
    }
}
