package com.webgisapplicationclientgeotools.mapper.implementation;

import com.webgisapplicationclientgeotools.dto.InstitutionDTO;
import com.webgisapplicationclientgeotools.dto.builder.InstitutionDTOBuilder;
import com.webgisapplicationclientgeotools.mapper.InstitutionMapper;
import com.webgisapplicationclientgeotools.models.Institution;
import org.springframework.stereotype.Component;

@Component
public class InstitutionMapperImplementation implements InstitutionMapper {

    @Override
    public InstitutionDTO institutionToInstitutionDTO(Institution institution) {
        return InstitutionDTOBuilder.builder()
                .name(institution.getName())
                .code(institution.getCode())
                .latitude(institution.getLatitude())
                .longitude(institution.getLongitude())
                .build();
    }
}
