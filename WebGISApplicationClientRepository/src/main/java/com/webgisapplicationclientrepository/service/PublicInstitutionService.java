package com.webgisapplicationclientrepository.service;


import com.webgisapplicationclientrepository.model.PublicInstitution;

import java.util.List;

public interface PublicInstitutionService {

    List<PublicInstitution> getAllPublicLocations();

    List<PublicInstitution> getPreferredPublicLocations(String code);

    PublicInstitution getPublicInstitutionByName(String code, String name);

    PublicInstitution getPublicInstitutionById(String code, Long id);
}
