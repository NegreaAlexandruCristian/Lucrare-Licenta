package com.webgisapplicationfeignclientgeotools.service;

import com.webgisapplicationfeignclientgeotools.models.Institution;
import com.webgisapplicationfeignclientgeotools.models.ObjectWrapper;
import com.webgisapplicationfeignclientgeotools.models.Point;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;
import java.util.List;

@FeignClient(name = "web-gis-client-geo-tools")
public interface ClientGeoToolsServiceFeign {

    @PostMapping("/user/location/distance")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    BigDecimal calculateDistanceBetweenTwoPoints(@RequestBody ObjectWrapper objectWrapper);

    @PostMapping("/user/location/zone")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    List<Institution> getSpecificLocationsFromZone(@RequestBody Point point);
}