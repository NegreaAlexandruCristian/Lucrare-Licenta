package com.webgisapplicationclientrepository.controller;


import com.webgisapplicationclientrepository.model.PublicInstitution;
import com.webgisapplicationclientrepository.service.PublicInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public/locations")
public class PublicLocationController {

    private final PublicInstitutionService publicInstitutionService;

    @Autowired
    public PublicLocationController(PublicInstitutionService publicInstitutionService) {
        this.publicInstitutionService = publicInstitutionService;
    }

    @GetMapping("/get/{type}")
    public List<PublicInstitution> getPreferredPublicLocations(@PathVariable("type") String code){
        return publicInstitutionService.getPreferredPublicLocations(code);
    }

    @GetMapping("/get/school/{name}")
    public PublicInstitution getSchoolLocationByName(@PathVariable("name") String name){
        return publicInstitutionService.getSchoolByName(name);
    }

    @GetMapping("/get/school/{id}")
    public PublicInstitution getSchoolLocationById(@PathVariable("id") Long id){
        return publicInstitutionService.getSchoolById(id);
    }

    @GetMapping("/get/university/{name}")
    public PublicInstitution getUniversityLocationByName(@PathVariable("name") String name){
        return publicInstitutionService.getUniversityByName(name);
    }

    @GetMapping("/get/university/{id}")
    public PublicInstitution getUniversityLocationById(@PathVariable("id") Long id){
        return publicInstitutionService.getUniversityById(id);
    }
}
