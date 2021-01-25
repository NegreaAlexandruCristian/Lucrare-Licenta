package com.webgisapplicationfeignclient.controller;

import com.webgisapplicationfeignclient.model.PublicInstitution;
import com.webgisapplicationfeignclient.service.PublicInstitutionServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public/locations")
public class PublicInstitutionResourceController{

    private final PublicInstitutionServiceFeign publicInstitutionServiceFeign;

    @Autowired
    public PublicInstitutionResourceController(PublicInstitutionServiceFeign publicInstitutionServiceFeign) {
        this.publicInstitutionServiceFeign = publicInstitutionServiceFeign;
    }

    @GetMapping("/get/{type}")
    public List<PublicInstitution> getPreferredPublicLocations(@PathVariable("type") String code){

        return publicInstitutionServiceFeign.getPreferredPublicLocations(code);
    }
}
