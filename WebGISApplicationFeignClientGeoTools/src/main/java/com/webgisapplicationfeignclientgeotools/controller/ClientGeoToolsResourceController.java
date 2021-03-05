package com.webgisapplicationfeignclientgeotools.controller;

import com.webgisapplicationfeignclientgeotools.models.Institution;
import com.webgisapplicationfeignclientgeotools.models.ObjectWrapper;
import com.webgisapplicationfeignclientgeotools.models.Point;
import com.webgisapplicationfeignclientgeotools.service.ClientGeoToolsServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping
public class ClientGeoToolsResourceController {

    private final ClientGeoToolsServiceFeign clientGeoToolsServiceFeign;

    @Autowired
    public ClientGeoToolsResourceController(ClientGeoToolsServiceFeign clientGeoToolsServiceFeign) {
        this.clientGeoToolsServiceFeign = clientGeoToolsServiceFeign;
    }

    @PostMapping("/user/location/distance")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    BigDecimal calculateDistanceBetweenTwoPoints(@RequestBody ObjectWrapper objectWrapper){
        return clientGeoToolsServiceFeign.calculateDistanceBetweenTwoPoints(objectWrapper);
    }

    @PostMapping("/user/location/zone")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    List<Institution> getSpecificLocationsFromZone(@RequestBody Point point){
        return clientGeoToolsServiceFeign.getSpecificLocationsFromZone(point);
    }
}
