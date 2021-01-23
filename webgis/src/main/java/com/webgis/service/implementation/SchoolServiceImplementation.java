package com.webgis.service.implementation;

import com.webgis.model.School;
import com.webgis.repositories.SchoolRepository;
import com.webgis.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
