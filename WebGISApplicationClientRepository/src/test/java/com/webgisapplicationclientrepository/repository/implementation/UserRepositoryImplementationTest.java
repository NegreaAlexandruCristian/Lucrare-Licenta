package com.webgisapplicationclientrepository.repository.implementation;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.GeoIp2Provider;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@SpringBootTest
class UserRepositoryImplementationTest {

    @Test
    void getUserCurrentLocation() throws IOException, GeoIp2Exception {

        final String uri = "https://api.ipify.org";
        RestTemplate restTemplate = new RestTemplate();

        String ip = restTemplate.getForObject(uri, String.class);
        String dbLocation = "src/main/resources/static/databse/GeoLite2-City.mmdb";
        File database = new File(dbLocation);
        DatabaseReader dbReader = new DatabaseReader.Builder(database)
                .build();

        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = dbReader.city(ipAddress);
        String countryName = response.getCountry().getName();
        String cityName = response.getCity().getName();
        String postal = response.getPostal().getCode();
        String state = response.getLeastSpecificSubdivision().getName();
    }
}