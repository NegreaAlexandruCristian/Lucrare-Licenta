package com.webgisapplicationclientrepository.mapper;

import com.webgisapplicationclientrepository.dto.InstitutionDTO;
import com.webgisapplicationclientrepository.dto.MedicalInstitutionDTO;
import com.webgisapplicationclientrepository.dto.PublicInstitutionDTO;
import com.webgisapplicationclientrepository.dto.TransportInstitutionDTO;
import com.webgisapplicationclientrepository.model.MedicalInstitution;
import com.webgisapplicationclientrepository.model.PublicInstitution;
import com.webgisapplicationclientrepository.model.TransportInstitution;
import com.webgisapplicationclientrepository.model.util.Institution;

public interface InstitutionMapper {

    MedicalInstitutionDTO medicalInstitutionToMedicalInstitutionDTO(MedicalInstitution medicalInstitution);

    PublicInstitutionDTO publicInstitutionToPublicInstitutionDTO(PublicInstitution publicInstitution);

    TransportInstitutionDTO transportInstitutionToTransportInstitutionDTO(TransportInstitution transportInstitution);

    InstitutionDTO institutionToInstitutionDTO(Institution institution);

    InstitutionDTO medicalInstitutionToInstitutionDTO(MedicalInstitutionDTO medicalInstitution);

    InstitutionDTO publicInstitutionToInstitutionDTO(PublicInstitutionDTO publicInstitution);

    InstitutionDTO transportInstitutionToInstitutionDTO(TransportInstitutionDTO transportInstitution);

}
