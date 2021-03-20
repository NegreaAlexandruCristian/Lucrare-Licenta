package com.webgisapplicationclientrepository.service;


import com.webgisapplicationclientrepository.dto.PublicInstitutionDTO;

import java.util.List;

public interface PublicInstitutionService {

    List<PublicInstitutionDTO> getAllPublicLocations();

    List<PublicInstitutionDTO> getPreferredPublicLocations(String code);

    PublicInstitutionDTO getPublicInstitutionByName(String code, String name);

    PublicInstitutionDTO getPublicInstitutionById(String code, Long id);
}
