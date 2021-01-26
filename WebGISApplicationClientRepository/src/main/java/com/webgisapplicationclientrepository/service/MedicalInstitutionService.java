package com.webgisapplicationclientrepository.service;

import com.webgisapplicationclientrepository.model.MedicalInstitution;
import com.webgisapplicationclientrepository.model.PublicInstitution;

import java.util.List;

public interface MedicalInstitutionService {

    List<MedicalInstitution> getPreferredMedicalLocations(String code);

    MedicalInstitution getHospitalByName(String name);

    MedicalInstitution getHospitalById(Long id);

    MedicalInstitution getPharmacyByName(String name);

    MedicalInstitution getPharmacyById(Long id);

    List<MedicalInstitution> getAllMedicalLocations();
}
