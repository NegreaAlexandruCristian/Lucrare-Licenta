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
    public List<PublicInstitution> getPreferredPublicLocations(String code) {
        List<PublicInstitution> publicInstitutionsList =  publicInstitutionRepository.getPreferredPublicLocations(code);
        return publicInstitutionsList;
    }
}
