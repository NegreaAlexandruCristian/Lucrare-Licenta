package com.webgisapplicationfeignclient.service;

import com.webgisapplicationfeignclient.model.MedicalInstitution;
import com.webgisapplicationfeignclient.model.PublicInstitution;
import com.webgisapplicationfeignclient.model.TransportInstitution;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "web-gis-client-repository")
public interface ClientServiceFeign {

    @GetMapping("/public/locations/get")
    List<PublicInstitution> getAllPublicLocations();

    @GetMapping("/public/locations/get/{type}")
    List<PublicInstitution> getPreferredPublicLocations(@PathVariable("type") String code);

    @GetMapping("/public/locations/get/school/name/{name}")
    PublicInstitution getSchoolLocationByName(@PathVariable("name") String name);

    @GetMapping("/public/locations/get/school/id/{id}")
    PublicInstitution getSchoolLocationById(@PathVariable("id") Long id);

    @GetMapping("/public/locations/get/university/name/{name}")
    PublicInstitution getUniversityLocationByName(@PathVariable("name") String name);

    @GetMapping("/public/locations/get/university/id/{id}")
    PublicInstitution getUniversityLocationById(@PathVariable("id") Long id);

    @GetMapping("/medical/locations/get")
    List<MedicalInstitution> getAllMedicalLocations();

    @GetMapping("/medical/locations/get/{type}")
    List<MedicalInstitution> getPreferredMedicalLocations(@PathVariable("type") String code);

    @GetMapping("/medical/locations/get/hospital/name/{name}")
    MedicalInstitution getHospitalLocationByName(@PathVariable("name") String name);

    @GetMapping("/medical/locations/get/hospital/id/{id}")
    MedicalInstitution getHospitalLocationById(@PathVariable("id") Long id);

    @GetMapping("/medical/locations/get/pharmacy/name/{name}")
    MedicalInstitution getPharmacyLocationByName(@PathVariable("name") String name);

    @GetMapping("/medical/locations/get/pharmacy/id/{id}")
    MedicalInstitution getPharmacyLocationById(@PathVariable("id") Long id);

    @GetMapping("/transport/locations/get")
    List<TransportInstitution> getAllTransportLocations();

    @GetMapping("/transport/locations/get/{type}")
    List<TransportInstitution> getPreferredTransportLocations(@PathVariable("type") String code);

    @GetMapping("/transport/locations/get/bus/station/name/{name}")
    TransportInstitution getBusStationLocationByName(@PathVariable("name") String name);

    @GetMapping("/transport/locations/get/bus/station/id/{id}")
    TransportInstitution getBusStationLocationById(@PathVariable("id") Long id);

}