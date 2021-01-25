package com.webgisapplicationfeignclient.service;

import com.webgisapplicationfeignclient.model.PublicInstitution;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "web-gis-client-repository")
public interface PublicInstitutionServiceFeign {

    @GetMapping("/public/locations/get/{type}")
    List<PublicInstitution> getPreferredPublicLocations(@PathVariable("type") String code);
}
