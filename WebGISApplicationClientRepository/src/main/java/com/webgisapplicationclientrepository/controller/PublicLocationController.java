package com.webgisapplicationclientrepository.controller;


import com.webgisapplicationclientrepository.model.PublicInstitution;
import com.webgisapplicationclientrepository.service.PublicInstitutionService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/locations")
public class PublicLocationController {

    private final PublicInstitutionService publicInstitutionService;

    @Autowired
    public PublicLocationController(PublicInstitutionService publicInstitutionService) {
        this.publicInstitutionService = publicInstitutionService;
    }

    @GetMapping("/get")
    @ResponseStatus(value = HttpStatus.OK)
    public List<PublicInstitution> getAllPublicLocations(){
        return publicInstitutionService.getAllPublicLocations();
    }

    @GetMapping("/get/{type}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<PublicInstitution> getPreferredPublicLocations(@PathVariable("type") String code){
        return publicInstitutionService.getPreferredPublicLocations(code);
    }

    @GetMapping("/get/school/name/{name}")
    @ResponseStatus(value = HttpStatus.OK)
    public PublicInstitution getSchoolLocationByName(@PathVariable("name") String name){
        return publicInstitutionService.getSchoolByName(name);
    }

    @GetMapping("/get/school/id/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public PublicInstitution getSchoolLocationById(@PathVariable("id") Long id){
        return publicInstitutionService.getSchoolById(id);
    }

    @GetMapping("/get/university/name/{name}")
    @ResponseStatus(value = HttpStatus.OK)
    public PublicInstitution getUniversityLocationByName(@PathVariable("name") String name){
        return publicInstitutionService.getUniversityByName(name);
    }

    @GetMapping("/get/university/id/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public PublicInstitution getUniversityLocationById(@PathVariable("id") Long id){
        return publicInstitutionService.getUniversityById(id);
    }
}
