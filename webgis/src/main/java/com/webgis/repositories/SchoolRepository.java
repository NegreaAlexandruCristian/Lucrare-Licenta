package com.webgis.repositories;

import com.webgis.model.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends CrudRepository<School, Long> {

    @Query(value = "SELECT schools.nume FROM public.schools schools WHERE schools.id = ?1",nativeQuery = true)
    String getSchoolLocation(Long id);
}
