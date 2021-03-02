package com.webgisapplicationclientrepository.service.implementation;

import com.webgisapplicationclientrepository.model.PublicInstitution;
import com.webgisapplicationclientrepository.repository.PublicInstitutionRepository;
import com.webgisapplicationclientrepository.service.PublicInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class PublicInstitutionServiceImplementation implements PublicInstitutionService {

    private final PublicInstitutionRepository publicInstitutionRepository;

    @Autowired
    public PublicInstitutionServiceImplementation(PublicInstitutionRepository publicInstitutionRepository) {
        this.publicInstitutionRepository = publicInstitutionRepository;
    }

    @Override
    public List<PublicInstitution> getAllPublicLocations() {
        return Stream.concat(publicInstitutionRepository.getUniversityLocations().stream(),
                publicInstitutionRepository.getSchoolLocations().stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<PublicInstitution> getPreferredPublicLocations(String code) {

        if(code.equalsIgnoreCase("university")){

            return publicInstitutionRepository.getUniversityLocations();

        } else if(code.equalsIgnoreCase("school")){

            return publicInstitutionRepository.getSchoolLocations();
        }

        return null;
    }

    @Override
    public PublicInstitution getPublicInstitutionByName(String code, String name) {
        String newCode = code.toLowerCase();
        switch (newCode){
            case "school":{
                return publicInstitutionRepository.getSchoolByName(name);
            }
            case "university":{
                return publicInstitutionRepository.getUniversityByName(name);
            }
            default: {
                return null;
                //TODO exception
            }
        }
    }

    @Override
    public PublicInstitution getPublicInstitutionById(String code, Long id) {
        String newCode = code.toLowerCase();
        switch (newCode){
            case "school":{
                return publicInstitutionRepository.getSchoolById(id);
            }
            case "university":{
                return publicInstitutionRepository.getUniversityById(id);
            }
            default: {
                return null;
                //TODO exception
            }
        }
    }


}
