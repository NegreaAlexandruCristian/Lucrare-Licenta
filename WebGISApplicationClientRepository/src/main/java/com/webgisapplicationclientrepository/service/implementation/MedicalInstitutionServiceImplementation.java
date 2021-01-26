package com.webgisapplicationclientrepository.service.implementation;

import com.webgisapplicationclientrepository.model.MedicalInstitution;
import com.webgisapplicationclientrepository.model.PublicInstitution;
import com.webgisapplicationclientrepository.repository.MedicalInstitutionRepository;
import com.webgisapplicationclientrepository.service.MedicalInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalInstitutionServiceImplementation implements MedicalInstitutionService {

    private final MedicalInstitutionRepository medicalInstitutionRepository;

    @Autowired
    public MedicalInstitutionServiceImplementation(MedicalInstitutionRepository medicalInstitutionRepository) {
        this.medicalInstitutionRepository = medicalInstitutionRepository;
    }

    @Override
    public List<MedicalInstitution> getPreferredMedicalLocations(String code) {

        if(code.equalsIgnoreCase("hospital")){

            return medicalInstitutionRepository.getHospitalLocations();

        } else if(code.equalsIgnoreCase("pharmacy")){

            return medicalInstitutionRepository.getPharmacyLocations();
        }

        return null;
    }

    @Override
    public MedicalInstitution getHospitalByName(String name) {
        return medicalInstitutionRepository.getHospitalByName(name);
    }

    @Override
    public MedicalInstitution getHospitalById(Long id) {
        return medicalInstitutionRepository.getHospitalById(id);
    }

    @Override
    public MedicalInstitution getPharmacyByName(String name) {
        return medicalInstitutionRepository.getPharmacyByName(name);
    }

    @Override
    public MedicalInstitution getPharmacyById(Long id) {
        return medicalInstitutionRepository.getPharmacyById(id);
    }

    @Override
    public List<MedicalInstitution> getAllMedicalLocations() {
        List<MedicalInstitution> medicalInstitutions = medicalInstitutionRepository.getHospitalLocations();
        medicalInstitutions.addAll(medicalInstitutionRepository.getPharmacyLocations());

        return medicalInstitutions;
    }
}
