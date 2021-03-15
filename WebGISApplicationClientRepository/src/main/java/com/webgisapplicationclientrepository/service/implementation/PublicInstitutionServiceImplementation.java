package com.webgisapplicationclientrepository.service.implementation;

import com.webgisapplicationclientrepository.exceptions.utils.NotAllowedException;
import com.webgisapplicationclientrepository.exceptions.utils.NotFoundException;
import com.webgisapplicationclientrepository.model.PublicInstitution;
import com.webgisapplicationclientrepository.repository.PublicInstitutionRepository;
import com.webgisapplicationclientrepository.service.PublicInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        code = code.toLowerCase();
        switch (code) {
            case "university": {
                return publicInstitutionRepository.getUniversityLocations();
            }
            case "school": {
                return publicInstitutionRepository.getSchoolLocations();
            }

            default: {
                throw new NotAllowedException();
            }
        }
    }

    //TODO partial search
    @Override
    public PublicInstitution getPublicInstitutionByName(String code, String name) {
        String newCode = code.toLowerCase();
        switch (newCode){
            case "school":{
                PublicInstitution publicInstitution =
                        publicInstitutionRepository.getSchoolByName(name);
                if(publicInstitution == null){
                    throw new NotFoundException();
                } else {
                    return publicInstitution;
                }
            }
            case "university":{
                PublicInstitution publicInstitution =
                        publicInstitutionRepository.getUniversityByName(name);
                if(publicInstitution == null){
                    throw new NotFoundException();
                } else {
                    return publicInstitution;
                }
            }
            default: {
                throw new NotAllowedException();
            }
        }
    }

    @Override
    public PublicInstitution getPublicInstitutionById(String code, Long id) {
        String newCode = code.toLowerCase();
        switch (newCode){
            case "school":{
                PublicInstitution publicInstitution =
                        publicInstitutionRepository.getSchoolById(id);
                if(publicInstitution == null){
                    throw new NotFoundException();
                } else {
                    return publicInstitution;
                }
            }
            case "university":{
                PublicInstitution publicInstitution =
                        publicInstitutionRepository.getUniversityById(id);
                if(publicInstitution == null){
                    throw new NotFoundException();
                } else {
                    return publicInstitution;
                }
            }
            default: {
                throw new NotAllowedException();
            }
        }
    }


}
