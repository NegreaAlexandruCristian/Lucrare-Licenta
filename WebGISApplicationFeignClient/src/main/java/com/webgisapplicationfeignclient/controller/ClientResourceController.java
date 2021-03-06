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

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping
public class ClientResourceController {

    private final ClientServiceFeign clientServiceFeign;

    @Autowired
    public ClientResourceController(ClientServiceFeign clientServiceFeign) {
        this.clientServiceFeign = clientServiceFeign;
    }

    @ResponseBody
    @GetMapping("/public/locations/get")
    List<PublicInstitution> getAllPublicLocations(){

        return clientServiceFeign.getAllPublicLocations();
    }

    @ResponseBody
    @GetMapping("/public/locations/get/{type}")
    public List<PublicInstitution> getPreferredPublicLocations(@PathVariable("type") String code){

        return clientServiceFeign.getPreferredPublicLocations(code);
    }

    @ResponseBody
    @GetMapping("/public/locations/get/{code}/name/{name}")
    PublicInstitution getPublicInstitutionLocationByName(@PathVariable("code") String code,
                                                         @PathVariable("name") String name){
        return clientServiceFeign.getPublicInstitutionLocationByName(code, name);
    }

    @ResponseBody
    @GetMapping("/public/locations/get/{code}/id/{id}")
    PublicInstitution getPublicInstitutionLocationById(@PathVariable("code") String code,
                                                       @PathVariable("id") Long id){
        return clientServiceFeign.getPublicInstitutionLocationById(code, id);
    }

    @ResponseBody
    @GetMapping("/medical/locations/get")
    List<MedicalInstitution> getAllMedicalLocations(){

        return clientServiceFeign.getAllMedicalLocations();
    }

    @ResponseBody
    @GetMapping("/medical/locations/get/{type}")
    public List<MedicalInstitution> getPreferredMedicalLocations(@PathVariable("type") String code){
        return clientServiceFeign.getPreferredMedicalLocations(code);
    }

    @ResponseBody
    @GetMapping("/medical/locations/get/{code}/name/{name}")
    public MedicalInstitution getMedicalInstitutionLocationByName(@PathVariable(name = "code") String code,
                                                                  @PathVariable(name = "name") String name){
        return clientServiceFeign.getMedicalInstitutionLocationByName(code, name);
    }

    @ResponseBody
    @GetMapping("/medical/locations/get/{code}/id/{id}")
    public MedicalInstitution getMedicalInstitutionLocationById(@PathVariable(name = "code") String code,
                                                                @PathVariable(name = "id") Long id){
        return clientServiceFeign.getMedicalInstitutionLocationById(code, id);
    }

    @ResponseBody
    @GetMapping("/transport/locations/get")
    List<TransportInstitution> getAllTransportLocations(){

        return clientServiceFeign.getAllTransportLocations();
    }

    @ResponseBody
    @GetMapping("/transport/locations/get/{type}")
    public List<TransportInstitution> getPreferredTransportLocations(@PathVariable("type") String code){
        return clientServiceFeign.getPreferredTransportLocations(code);
    }

    @ResponseBody
    @GetMapping("/transport/locations/get/bus/station/name/{name}")
    public TransportInstitution getBusStationLocationByName(@PathVariable("name") String name){
        return clientServiceFeign.getBusStationLocationByName(name);
    }

    @ResponseBody
    @GetMapping("/transport/locations/get/bus/station/id/{id}")
    public TransportInstitution getBusStationLocationById(@PathVariable("id") Long id){
        return clientServiceFeign.getBusStationLocationById(id);
    }

    @ResponseBody
    @PostMapping("/user/location/distance")
    public BigDecimal calculateDistance(@Valid @RequestBody ObjectWrapper objectWrapper){
        return clientServiceFeign.calculateDistance(objectWrapper);
    }

    @ResponseBody
    @PostMapping("/user/location/zone")
    public List<Institution> getLocationsFromZone(@Valid @RequestBody Point point){
        return clientServiceFeign.getLocationsFromZone(point);
    }

    @ResponseBody
    @PostMapping("/user/location/all")
    public List<Institution> getAllLocationsFromZone(@Valid @RequestBody Point point){
        return clientServiceFeign.getAllLocationsFromZone(point);
    }

    @ResponseBody
    @PostMapping("/user/location/shortest")
    Institution getShortestLocationFromZone(@Valid @RequestBody Point point){
        return clientServiceFeign.getShortestLocationFromZone(point);
    }
}
