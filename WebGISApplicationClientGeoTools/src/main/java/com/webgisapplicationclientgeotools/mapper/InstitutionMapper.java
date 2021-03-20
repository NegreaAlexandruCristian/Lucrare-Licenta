package com.webgisapplicationclientgeotools.mapper;

import com.webgisapplicationclientgeotools.dto.InstitutionDTO;
import com.webgisapplicationclientgeotools.models.Institution;

public interface InstitutionMapper {

    InstitutionDTO institutionToInstitutionDTO(Institution institution);
}
