package com.webgisapplicationclientrepository.service.implementation;

import com.webgisapplicationclientrepository.model.MedicalInstitution;
import com.webgisapplicationclientrepository.repository.MedicalInstitutionRepository;
import com.webgisapplicationclientrepository.service.MedicalInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public List<MedicalInstitution> getAllMedicalLocations() {
        return Stream.concat(medicalInstitutionRepository.getPharmacyLocations().stream(),
                medicalInstitutionRepository.getHospitalLocations().stream())
                .collect(Collectors.toList());
    }

    @Override
    public MedicalInstitution getMedicalInstitutionByName(String code, String name) {

        String newCode = code.toLowerCase();
        switch (newCode){
            case "hospital":{
                return medicalInstitutionRepository.getHospitalByName(name);
            }
            case "pharmacy":{
                return medicalInstitutionRepository.getPharmacyByName(name);
            }
            default: {
                return null;
                //TODO exception
            }
        }
    }

    @Override
    public MedicalInstitution getMedicalInstitutionById(String code, Long id) {
        String newCode = code.toLowerCase();
        switch (newCode){
            case "hospital":{
                return medicalInstitutionRepository.getHospitalById(id);
            }
            case "pharmacy":{
                return medicalInstitutionRepository.getPharmacyById(id);
            }
            default:{
                return null;
                //TODO exception
            }
        }
    }
}
