package com.webgisapplicationclientrepository.service;

import com.webgisapplicationclientrepository.model.MedicalInstitution;
import com.webgisapplicationclientrepository.model.PublicInstitution;

import java.util.List;

public interface MedicalInstitutionService {

    List<MedicalInstitution> getPreferredMedicalLocations(String code);

    List<MedicalInstitution> getAllMedicalLocations();

    MedicalInstitution getMedicalInstitutionByName(String code, String name);

    MedicalInstitution getMedicalInstitutionById(String code, Long id);
}
