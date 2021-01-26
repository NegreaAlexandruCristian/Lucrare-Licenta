package com.webgisapplicationclientrepository.repository;

import com.webgisapplicationclientrepository.model.PublicInstitution;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MedicalInstitutionRepository {

    @Query(value = "SELECT hospital.id AS id,hospital.nume AS nume, hospital.code AS code" +
            ", hospital.latitude AS latitude, hospital.longitude AS longitude" +
            " FROM public.hospital hospital" +
            " WHERE hospital.code = ?1"
            ,nativeQuery = true)
    List<PublicInstitution> getHospitalLocations(String code);
}
