package com.webgisapplicationclientrepository.service.implementation;

import com.webgisapplicationclientrepository.dto.MedicalInstitutionDTO;
import com.webgisapplicationclientrepository.dto.PublicInstitutionDTO;
import com.webgisapplicationclientrepository.dto.PublicInstitutionDTO;
import com.webgisapplicationclientrepository.exceptions.utils.NotAllowedException;
import com.webgisapplicationclientrepository.exceptions.utils.NotFoundException;
import com.webgisapplicationclientrepository.mapper.InstitutionMapper;
import com.webgisapplicationclientrepository.model.PublicInstitution;
import com.webgisapplicationclientrepository.repository.PublicInstitutionRepository;
import com.webgisapplicationclientrepository.service.PublicInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class PublicInstitutionServiceImplementation implements PublicInstitutionService {

    private final PublicInstitutionRepository publicInstitutionRepository;
    private final InstitutionMapper institutionMapper;
    private final EntityManager entityManager;

    @Autowired
    public PublicInstitutionServiceImplementation(PublicInstitutionRepository publicInstitutionRepository, InstitutionMapper institutionMapper, EntityManager entityManager) {
        this.publicInstitutionRepository = publicInstitutionRepository;
        this.institutionMapper = institutionMapper;
        this.entityManager = entityManager;
    }

    private PublicInstitutionDTO partialNameSearch(String name){

        name = name.toLowerCase();
        ArrayList<String> partialNames = new ArrayList<>();
        String[] strings = name.split(" ");
        for(int index = 0 ; index < strings.length ; index++){
            String temp = "";
            for(int j = 0 ; j < index + 1 ; j++){
                temp = String.format("%s%s ", temp, strings[j]);
            }
            partialNames.add(temp);
        }
        List<PublicInstitutionDTO> PublicInstitutionDTOS = new ArrayList<>(getAllPublicLocations());
        for(int index = partialNames.size() - 1; index > 0 ; index --){
            String temporaryName = partialNames.get(index);
            for(int j = 0 ; j < temporaryName.length() ; j ++){
                String temp = temporaryName.substring(0, temporaryName.length()  - j);
                for(PublicInstitutionDTO PublicInstitutionDTO : PublicInstitutionDTOS){
                    if(PublicInstitutionDTO.getName().toLowerCase().contains(temp)){
                        System.out.println(temp);
                        return PublicInstitutionDTO;
                    }
                }
            }

        }
        return null;
    }

    @Override
    public List<PublicInstitutionDTO> getAllPublicLocations() {
        List<PublicInstitutionDTO> PublicInstitutionDTOS = publicInstitutionRepository.getSchoolLocations()
                .stream()
                .map(institutionMapper::publicInstitutionToPublicInstitutionDTO)
                .collect(Collectors.toList());
        entityManager.clear();
        PublicInstitutionDTOS.addAll(
                publicInstitutionRepository.getUniversityLocations()
                        .stream()
                        .map(institutionMapper::publicInstitutionToPublicInstitutionDTO)
                        .collect(Collectors.toList())
        );

        return PublicInstitutionDTOS;
    }

    @Override
    public List<PublicInstitutionDTO> getPreferredPublicLocations(String code) {

        code = code.toLowerCase();
        switch (code) {
            case "university": {
                return publicInstitutionRepository.getUniversityLocations()
                        .stream()
                        .map(institutionMapper::publicInstitutionToPublicInstitutionDTO)
                        .collect(Collectors.toList());
            }
            case "school": {
                return publicInstitutionRepository.getSchoolLocations()
                        .stream()
                        .map(institutionMapper::publicInstitutionToPublicInstitutionDTO)
                        .collect(Collectors.toList());
            }

            default: {
                throw new NotAllowedException();
            }
        }
    }

    //TODO partial search
    @Override
    public PublicInstitutionDTO getPublicInstitutionByName(String code, String name) {
        String newCode = code.toLowerCase();
        switch (newCode){
            case "school":{
                PublicInstitution publicInstitution =
                        publicInstitutionRepository.getSchoolByName(name);
                if(publicInstitution == null){
                    PublicInstitutionDTO publicInstitutionDTO = partialNameSearch(name);
                    if(publicInstitutionDTO != null){
                        return publicInstitutionDTO;
                    } else {
                        throw new NotFoundException();
                    }
                } else {
                    return institutionMapper.publicInstitutionToPublicInstitutionDTO(publicInstitution);
                }
            }
            case "university":{
                PublicInstitution publicInstitution =
                        publicInstitutionRepository.getUniversityByName(name);
                if(publicInstitution == null){
                    throw new NotFoundException();
                } else {
                    return institutionMapper.publicInstitutionToPublicInstitutionDTO(publicInstitution);
                }
            }
            default: {
                throw new NotAllowedException();
            }
        }
    }

    @Override
    public PublicInstitutionDTO getPublicInstitutionById(String code, Long id) {
        String newCode = code.toLowerCase();
        switch (newCode){
            case "school":{
                PublicInstitution publicInstitution =
                        publicInstitutionRepository.getSchoolById(id);
                if(publicInstitution == null){
                    throw new NotFoundException();
                } else {
                    return institutionMapper.publicInstitutionToPublicInstitutionDTO(publicInstitution);
                }
            }
            case "university":{
                PublicInstitution publicInstitution =
                        publicInstitutionRepository.getUniversityById(id);
                if(publicInstitution == null){
                    throw new NotFoundException();
                } else {
                    return institutionMapper.publicInstitutionToPublicInstitutionDTO(publicInstitution);
                }
            }
            default: {
                throw new NotAllowedException();
            }
        }
    }


}
