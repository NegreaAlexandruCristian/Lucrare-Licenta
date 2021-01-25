package com.webgisapplicationclientrepository.service;


import com.webgisapplicationclientrepository.model.PublicInstitution;

import java.util.List;

public interface PublicInstitutionService {
    List<PublicInstitution> getPreferredPublicLocations(String code);
}
