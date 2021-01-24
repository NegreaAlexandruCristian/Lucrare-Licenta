package com.webgisapplicationclientrepository.service.implementation;

import com.webgisapplicationclientrepository.model.PublicInstitution;
import com.webgisapplicationclientrepository.repository.PublicInstitutionRepository;
import com.webgisapplicationclientrepository.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SchoolServiceImplementation implements SchoolService {

    private final PublicInstitutionRepository publicInstitutionRepository;

    @Autowired
    public SchoolServiceImplementation(PublicInstitutionRepository publicInstitutionRepository) {
        this.publicInstitutionRepository = publicInstitutionRepository;
    }


    @Override
    public PublicInstitution getSchoolLocation(Long id) {
        return publicInstitutionRepository.getSchoolLocation(id);
    }
}
