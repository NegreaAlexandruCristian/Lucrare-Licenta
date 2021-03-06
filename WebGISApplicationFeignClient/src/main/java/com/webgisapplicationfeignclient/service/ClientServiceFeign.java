package com.webgisapplicationfeignclient.service;

import com.webgisapplicationfeignclient.model.MedicalInstitution;
import com.webgisapplicationfeignclient.model.PublicInstitution;
import com.webgisapplicationfeignclient.model.TransportInstitution;
import com.webgisapplicationfeignclient.model.util.Institution;
import com.webgisapplicationfeignclient.model.util.ObjectWrapper;
import com.webgisapplicationfeignclient.model.util.Point;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@FeignClient(name = "web-gis-client-repository")
public interface ClientServiceFeign {

    @ResponseBody
    @GetMapping("/public/locations/get")
    List<PublicInstitution> getAllPublicLocations();

    @ResponseBody
    @GetMapping("/public/locations/get/{type}")
    List<PublicInstitution> getPreferredPublicLocations(@PathVariable("type") String code);

    @ResponseBody
    @GetMapping("/public/locations/get/{code}/name/{name}")
    PublicInstitution getPublicInstitutionLocationByName(@PathVariable("code") String code,
                                                         @PathVariable("name") String name);
    @ResponseBody
    @GetMapping("/public/locations/get/{code}/id/{id}")
    PublicInstitution getPublicInstitutionLocationById(@PathVariable("code") String code,
                                                       @PathVariable("id") Long id);
    @ResponseBody
    @GetMapping("/medical/locations/get")
    List<MedicalInstitution> getAllMedicalLocations();

    @ResponseBody
    @GetMapping("/medical/locations/get/{type}")
    List<MedicalInstitution> getPreferredMedicalLocations(@PathVariable("type") String code);

    @ResponseBody
    @GetMapping("/medical/locations/get/{code}/name/{name}")
    MedicalInstitution getMedicalInstitutionLocationByName(@PathVariable(name = "code") String code,
                                                                  @PathVariable(name = "name") String name);
    @ResponseBody
    @GetMapping("/medical/locations/get/{code}/id/{id}")
    MedicalInstitution getMedicalInstitutionLocationById(@PathVariable(name = "code") String code,
                                                         @PathVariable("id") Long id);
    @ResponseBody
    @GetMapping("/transport/locations/get")
    List<TransportInstitution> getAllTransportLocations();

    @ResponseBody
    @GetMapping("/transport/locations/get/{type}")
    List<TransportInstitution> getPreferredTransportLocations(@PathVariable("type") String code);

    @ResponseBody
    @GetMapping("/transport/locations/get/bus/station/name/{name}")
    TransportInstitution getBusStationLocationByName(@PathVariable("name") String name);

    @ResponseBody
    @GetMapping("/transport/locations/get/bus/station/id/{id}")
    TransportInstitution getBusStationLocationById(@PathVariable("id") Long id);

    @ResponseBody
    @PostMapping("/user/location/distance")
    BigDecimal calculateDistance(@Valid @RequestBody ObjectWrapper objectWrapper);

    @ResponseBody
    @PostMapping("/user/location/zone")
    List<Institution> getLocationsFromZone(@Valid @RequestBody Point point);

    @ResponseBody
    @PostMapping("/user/location/all")
    List<Institution> getAllLocationsFromZone(@Valid @RequestBody Point point);

    @ResponseBody
    @PostMapping("/user/location/shortest")
    Institution getShortestLocationFromZone(@Valid @RequestBody Point point);

}