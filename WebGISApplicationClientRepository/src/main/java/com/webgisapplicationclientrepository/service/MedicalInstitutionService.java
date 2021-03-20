package com.webgisapplicationclientrepository.service;

import com.webgisapplicationclientrepository.dto.MedicalInstitutionDTO;

import java.util.List;

public interface MedicalInstitutionService {

    List<MedicalInstitutionDTO> getPreferredMedicalLocations(String code);

    List<MedicalInstitutionDTO> getAllMedicalLocations();

    MedicalInstitutionDTO getMedicalInstitutionByName(String code, String name);

    MedicalInstitutionDTO getMedicalInstitutionById(String code, Long id);
}
