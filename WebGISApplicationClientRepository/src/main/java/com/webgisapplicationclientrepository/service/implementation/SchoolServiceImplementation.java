package com.webgisapplicationclientrepository.service.implementation;

import com.webgisapplicationclientrepository.repository.SchoolRepository;
import com.webgisapplicationclientrepository.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SchoolServiceImplementation implements SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolServiceImplementation(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }


    @Override
    public String getSchoolLocation(Long id) {
        return schoolRepository.getSchoolLocation(id);
    }
}
