package com.webgisapplicationclientrepository.service.implementation;

import com.webgisapplicationclientrepository.exceptions.utils.NotAllowedException;
import com.webgisapplicationclientrepository.exceptions.utils.NotFoundException;
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

        code = code.toLowerCase();
        switch (code){
            case "hospital":{
                return medicalInstitutionRepository.getHospitalLocations();
            }
            case "pharmacy":{
                return medicalInstitutionRepository.getPharmacyLocations();
            }

            default:{
                throw new NotAllowedException();
            }
        }
    }

    //TODO To check why it's buggy
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
                MedicalInstitution medicalInstitution =
                        medicalInstitutionRepository.getHospitalByName(name);
                if(medicalInstitution == null){
                    throw new NotFoundException();
                } else {
                    return medicalInstitution;
                }
            }
            case "pharmacy":{
                MedicalInstitution medicalInstitution =
                        medicalInstitutionRepository.getPharmacyByName(name);
                if(medicalInstitution == null){
                    throw new NotFoundException();
                } else {
                    return medicalInstitution;
                }
            }
            default: {
                throw new NotAllowedException();
            }
        }
    }

    @Override
    public MedicalInstitution getMedicalInstitutionById(String code, Long id) {
        String newCode = code.toLowerCase();
        switch (newCode){
            case "hospital":{
                MedicalInstitution medicalInstitution =
                        medicalInstitutionRepository.getHospitalById(id);
                if(medicalInstitution == null){
                    throw new NotFoundException();
                } else {
                    return medicalInstitution;
                }
            }
            case "pharmacy":{
                MedicalInstitution medicalInstitution =
                        medicalInstitutionRepository.getPharmacyById(id);
                if(medicalInstitution == null){
                    throw new NotFoundException();
                } else {
                    return medicalInstitution;
                }
            }
            default:{
                throw new NotAllowedException();
            }
        }
    }
}
