package com.webgisapplicationclientrepository.mapper.implementation;

import com.webgisapplicationclientrepository.dto.InstitutionDTO;
import com.webgisapplicationclientrepository.dto.MedicalInstitutionDTO;
import com.webgisapplicationclientrepository.dto.PublicInstitutionDTO;
import com.webgisapplicationclientrepository.dto.TransportInstitutionDTO;
import com.webgisapplicationclientrepository.dto.builder.InstitutionDTOBuilder;
import com.webgisapplicationclientrepository.dto.builder.MedicalInstitutionDTOBuilder;
import com.webgisapplicationclientrepository.dto.builder.PublicInstitutionDTOBuilder;
import com.webgisapplicationclientrepository.dto.builder.TransportInstitutionDTOBuilder;
import com.webgisapplicationclientrepository.mapper.InstitutionMapper;
import com.webgisapplicationclientrepository.model.MedicalInstitution;
import com.webgisapplicationclientrepository.model.PublicInstitution;
import com.webgisapplicationclientrepository.model.TransportInstitution;
import com.webgisapplicationclientrepository.model.util.Institution;
import org.springframework.stereotype.Component;

@Component
public class InstitutionMapperImplementation implements InstitutionMapper {

    @Override
    public MedicalInstitutionDTO medicalInstitutionToMedicalInstitutionDTO(MedicalInstitution medicalInstitution) {

        return MedicalInstitutionDTOBuilder.builder()
                .name(medicalInstitution.getName())
                .code(medicalInstitution.getCode())
                .latitude(medicalInstitution.getLatitude())
                .longitude(medicalInstitution.getLongitude())
                .build();
    }

    @Override
    public PublicInstitutionDTO publicInstitutionToPublicInstitutionDTO(PublicInstitution publicInstitution) {
        return PublicInstitutionDTOBuilder.builder()
                .name(publicInstitution.getName())
                .code(publicInstitution.getCode())
                .latitude(publicInstitution.getLatitude())
                .longitude(publicInstitution.getLongitude())
                .build();
    }

    @Override
    public TransportInstitutionDTO transportInstitutionToTransportInstitutionDTO(TransportInstitution transportInstitution) {
        return TransportInstitutionDTOBuilder.builder()
                .name(transportInstitution.getName())
                .code(transportInstitution.getCode())
                .latitude(transportInstitution.getLatitude())
                .longitude(transportInstitution.getLongitude())
                .build();
    }

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
