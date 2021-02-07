package com.webgisapplicationfeignclient.controller;

import com.webgisapplicationfeignclient.model.MedicalInstitution;
import com.webgisapplicationfeignclient.model.PublicInstitution;
import com.webgisapplicationfeignclient.model.TransportInstitution;
import com.webgisapplicationfeignclient.model.util.Institution;
import com.webgisapplicationfeignclient.model.util.ObjectWrapper;
import com.webgisapplicationfeignclient.model.util.Point;
import com.webgisapplicationfeignclient.service.ClientServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ClientResourceController {

    private final ClientServiceFeign clientServiceFeign;

    @Autowired
    public ClientResourceController(ClientServiceFeign clientServiceFeign) {
        this.clientServiceFeign = clientServiceFeign;
    }

    @GetMapping("/public/locations/get")
    List<PublicInstitution> getAllPublicLocations(){

        return clientServiceFeign.getAllPublicLocations();
    }

    @GetMapping("/public/locations/get/{type}")
    public List<PublicInstitution> getPreferredPublicLocations(@PathVariable("type") String code){

        return clientServiceFeign.getPreferredPublicLocations(code);
    }

    @GetMapping("/public/locations/get/school/name/{name}")
    public PublicInstitution getSchoolLocationByName(@PathVariable("name") String name){
        return clientServiceFeign.getSchoolLocationByName(name);
    }

    @GetMapping("/public/locations/get/school/id/{id}")
    public PublicInstitution getSchoolLocationById(@PathVariable("id") Long id){
        return clientServiceFeign.getSchoolLocationById(id);
    }

    @GetMapping("/public/locations/get/university/name/{name}")
    public PublicInstitution getUniversityLocationByName(@PathVariable("name") String name){
        return clientServiceFeign.getUniversityLocationByName(name);
    }

    @GetMapping("/public/locations/get/university/id/{id}")
    public PublicInstitution getUniversityLocationById(@PathVariable("id") Long id){
        return clientServiceFeign.getUniversityLocationById(id);
    }

    @GetMapping("/medical/locations/get")
    List<MedicalInstitution> getAllMedicalLocations(){

        return clientServiceFeign.getAllMedicalLocations();
    }

    @GetMapping("/medical/locations/get/{type}")
    public List<MedicalInstitution> getPreferredMedicalLocations(@PathVariable("type") String code){
        return clientServiceFeign.getPreferredMedicalLocations(code);
    }

    @GetMapping("/medical/locations/get/hospital/name/{name}")
    public MedicalInstitution getHospitalLocationByName(@PathVariable("name") String name){
        return clientServiceFeign.getHospitalLocationByName(name);
    }

    @GetMapping("/medical/locations/get/hospital/id/{id}")
    public MedicalInstitution getHospitalLocationById(@PathVariable("id") Long id){
        return clientServiceFeign.getHospitalLocationById(id);
    }

    @GetMapping("/medical/locations/get/pharmacy/name/{name}")
    public MedicalInstitution getPharmacyLocationByName(@PathVariable("name") String name){
        return clientServiceFeign.getPharmacyLocationByName(name);
    }

    @GetMapping("/medical/locations/get/pharmacy/id/{id}")
    public MedicalInstitution getPharmacyLocationById(@PathVariable("id") Long id){
        return clientServiceFeign.getPharmacyLocationById(id);
    }

    @GetMapping("/transport/locations/get")
    List<TransportInstitution> getAllTransportLocations(){

        return clientServiceFeign.getAllTransportLocations();
    }

    @GetMapping("/transport/locations/get/{type}")
    public List<TransportInstitution> getPreferredTransportLocations(@PathVariable("type") String code){
        return clientServiceFeign.getPreferredTransportLocations(code);
    }

    @GetMapping("/transport/locations/get/bus/station/name/{name}")
    public TransportInstitution getBusStationLocationByName(@PathVariable("name") String name){
        return clientServiceFeign.getBusStationLocationByName(name);
    }

    @GetMapping("/transport/locations/get/bus/station/id/{id}")
    public TransportInstitution getBusStationLocationById(@PathVariable("id") Long id){
        return clientServiceFeign.getBusStationLocationById(id);
    }

    @PostMapping("/user/location/distance")
    public Number calculateDistance(@RequestBody ObjectWrapper objectWrapper){
        return clientServiceFeign.calculateDistance(objectWrapper);
    }

    @PostMapping("/user/location/zone")
    public List<Institution> getLocationsFromZone(@RequestBody Point point){
        return clientServiceFeign.getLocationsFromZone(point);
    }

    @PostMapping("/user/location/all")
    public List<Institution> getAllLocationsFromZone(@RequestBody Point point){
        return clientServiceFeign.getLocationsFromZone(point);
    }
}
