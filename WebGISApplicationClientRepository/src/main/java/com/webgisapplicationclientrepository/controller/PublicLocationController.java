package com.webgisapplicationclientrepository.controller;


import com.webgisapplicationclientrepository.model.PublicInstitution;
import com.webgisapplicationclientrepository.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publiclocation/school")
public class PublicLocationController {

    private final SchoolService schoolService;

    @Autowired
    public PublicLocationController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PublicInstitution> getSchoolLocation(@PathVariable("id") Long id){

        System.out.println(id);
        return new ResponseEntity<>(schoolService.getSchoolLocation(id), HttpStatus.OK);
    }
}
