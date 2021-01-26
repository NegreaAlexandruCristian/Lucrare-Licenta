package com.webgisapplicationclientrepository.service.implementation;

import com.webgisapplicationclientrepository.model.PublicInstitution;
import com.webgisapplicationclientrepository.repository.PublicInstitutionRepository;
import com.webgisapplicationclientrepository.service.PublicInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PublicInstitutionServiceImplementation implements PublicInstitutionService {

    private final PublicInstitutionRepository publicInstitutionRepository;

    @Autowired
    public PublicInstitutionServiceImplementation(PublicInstitutionRepository publicInstitutionRepository) {
        this.publicInstitutionRepository = publicInstitutionRepository;
    }


    @Override
    public List<PublicInstitution> getAllPublicLocations() {
        List<PublicInstitution> publicInstitutions = publicInstitutionRepository.getSchoolLocations();
        publicInstitutions.addAll(publicInstitutionRepository.getUniversityLocations());

        return publicInstitutions;
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
    public PublicInstitution getSchoolByName(String name) {
        return publicInstitutionRepository.getSchoolByName(name);
    }

    @Override
    public PublicInstitution getSchoolById(Long id) {
        System.out.println(id);
        return publicInstitutionRepository.getSchoolById(id);
    }

    @Override
    public PublicInstitution getUniversityByName(String name) {
        return publicInstitutionRepository.getUniversityByName(name);
    }

    @Override
    public PublicInstitution getUniversityById(Long id) {
        return publicInstitutionRepository.getUniversityById(id);
    }
}
