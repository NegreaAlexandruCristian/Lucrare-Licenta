package com.webgisapplicationclientrepository.repository;

import com.webgisapplicationclientrepository.model.PublicInstitution;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PublicInstitutionRepository extends CrudRepository<PublicInstitution, Long> {

    @Query(value = "SELECT  schools.id AS id,schools.nume AS nume, schools.code AS code" +
            " FROM public.schools schools" +
            " WHERE schools.id = ?1"
            ,nativeQuery = true)
    PublicInstitution getSchoolLocation(Long id);
}
