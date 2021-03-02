package com.webgisapplicationfeignclient.service;

import com.webgisapplicationfeignclient.model.MedicalInstitution;
import com.webgisapplicationfeignclient.model.PublicInstitution;
import com.webgisapplicationfeignclient.model.TransportInstitution;
import com.webgisapplicationfeignclient.model.util.Institution;
import com.webgisapplicationfeignclient.model.util.ObjectWrapper;
import com.webgisapplicationfeignclient.model.util.Point;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "web-gis-client-repository")
public interface ClientServiceFeign {

    @GetMapping("/public/locations/get")
    List<PublicInstitution> getAllPublicLocations();

    @GetMapping("/public/locations/get/{type}")
    List<PublicInstitution> getPreferredPublicLocations(@PathVariable("type") String code);

    @GetMapping("/public/locations/get/{code}/name/{name}")
    PublicInstitution getPublicInstitutionLocationByName(@PathVariable("code") String code,
                                                         @PathVariable("name") String name);

    @GetMapping("/public/locations/get/{code}/id/{id}")
    PublicInstitution getPublicInstitutionLocationById(@PathVariable("code") String code,
                                                       @PathVariable("id") Long id);

    @GetMapping("/medical/locations/get")
    List<MedicalInstitution> getAllMedicalLocations();

    @GetMapping("/medical/locations/get/{type}")
    List<MedicalInstitution> getPreferredMedicalLocations(@PathVariable("type") String code);

    @GetMapping("/medical/locations/get/{code}/name/{name}")
    MedicalInstitution getMedicalInstitutionLocationByName(@PathVariable(name = "code") String code,
                                                                  @PathVariable(name = "name") String name);

    @GetMapping("/medical/locations/get/{code}/id/{id}")
    MedicalInstitution getMedicalInstitutionLocationById(@PathVariable(name = "code") String code,
                                                         @PathVariable("id") Long id);

    @GetMapping("/transport/locations/get")
    List<TransportInstitution> getAllTransportLocations();

    @GetMapping("/transport/locations/get/{type}")
    List<TransportInstitution> getPreferredTransportLocations(@PathVariable("type") String code);

    @GetMapping("/transport/locations/get/bus/station/name/{name}")
    TransportInstitution getBusStationLocationByName(@PathVariable("name") String name);

    @GetMapping("/transport/locations/get/bus/station/id/{id}")
    TransportInstitution getBusStationLocationById(@PathVariable("id") Long id);

    @PostMapping("/user/location/distance")
    Number calculateDistance(@RequestBody ObjectWrapper objectWrapper);

    @PostMapping("/user/location/zone")
    List<Institution> getLocationsFromZone(@RequestBody Point point);

    @PostMapping("/user/location/all")
    List<Institution> getAllLocationsFromZone(@RequestBody Point point);

    @PostMapping("/user/location/shortest")
    Institution getShortestLocationFromZone(@RequestBody Point point);

}