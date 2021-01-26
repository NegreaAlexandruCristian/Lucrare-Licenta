package com.webgisapplicationclientrepository.service;


import com.webgisapplicationclientrepository.model.PublicInstitution;

import java.util.List;

public interface PublicInstitutionService {

    List<PublicInstitution> getAllPublicLocations();

    List<PublicInstitution> getPreferredPublicLocations(String code);

    PublicInstitution getSchoolByName(String name);

    PublicInstitution getSchoolById(Long id);

    PublicInstitution getUniversityByName(String name);

    PublicInstitution getUniversityById(Long id);
}
