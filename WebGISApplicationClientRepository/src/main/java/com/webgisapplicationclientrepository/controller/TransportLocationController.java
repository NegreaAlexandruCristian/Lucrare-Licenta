package com.webgisapplicationclientrepository.controller;

import com.webgisapplicationclientrepository.model.TransportInstitution;
import com.webgisapplicationclientrepository.service.TransportInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transport/locations")
public class TransportLocationController {

    private final TransportInstitutionService transportInstitutionService;

    @Autowired
    public TransportLocationController(TransportInstitutionService transportInstitutionService) {
        this.transportInstitutionService = transportInstitutionService;
    }


    @GetMapping("/get")
    public List<TransportInstitution> getAllTransportLocations(){
        return transportInstitutionService.getAllTransportLocations();
    }

    @GetMapping("/get/{type}")
    public List<TransportInstitution> getPreferredTransportLocations(@PathVariable("type") String code){
        return transportInstitutionService.getPreferredTransportLocations(code);
    }

    @GetMapping("/get/bus/station/name/{name}")
    public TransportInstitution getBusStationLocationByName(@PathVariable("name") String name){
        return transportInstitutionService.getBusStationLocationByName(name);
    }

    @GetMapping("/get/bus/station/id/{id}")
    public TransportInstitution getBusStationLocationById(@PathVariable("id") Long id){
        System.out.println("ID : " + id);
        return transportInstitutionService.getBusStationLocationById(id);
    }
}
