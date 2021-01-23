package com.webgis.controller;

import com.webgis.model.School;
import com.webgis.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/publiclocation/school")
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getSchoolLocation(@PathVariable("id") Long id){

        System.out.println(id);
        return new ResponseEntity<>(schoolService.getSchoolLocation(id), HttpStatus.OK);
    }
}
