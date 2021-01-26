package com.webgisapplicationclientrepository.repository;

import com.webgisapplicationclientrepository.model.MedicalInstitution;
import com.webgisapplicationclientrepository.model.TransportInstitution;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MedicalInstitutionRepository extends CrudRepository<MedicalInstitution, Long>{

    @Query(value = "SELECT hospital.id AS id,hospital.nume AS nume, hospital.code AS code" +
            ", hospital.latitude AS latitude, hospital.longitude AS longitude" +
            " FROM public.hospital hospital"
            ,nativeQuery = true)
    List<MedicalInstitution> getHospitalLocations();

    @Query(value = "SELECT hospital.id AS id,hospital.nume AS nume, hospital.code AS code" +
            ", hospital.latitude AS latitude, hospital.longitude AS longitude" +
            " FROM public.hospital hospital" +
            " WHERE hospital.id = ?1"
            ,nativeQuery = true)
    MedicalInstitution getHospitalById(Long id);

    @Query(value = "SELECT hospital.id AS id,hospital.nume AS nume, hospital.code AS code" +
            ", hospital.latitude AS latitude, hospital.longitude AS longitude" +
            " FROM public.hospital hospital" +
            " WHERE hospital.nume = ?1"
            ,nativeQuery = true)
    MedicalInstitution getHospitalByName(String name);

    @Query(value = "SELECT pharmacy.id AS id,pharmacy.nume AS nume, pharmacy.code AS code" +
            ", pharmacy.latitude AS latitude, pharmacy.longitude AS longitude" +
            " FROM public.pharmacy pharmacy"
            ,nativeQuery = true)
    List<MedicalInstitution> getPharmacyLocations();

    @Query(value = "SELECT pharmacy.id AS id,pharmacy.nume AS nume, pharmacy.code AS code" +
            ", pharmacy.latitude AS latitude, pharmacy.longitude AS longitude" +
            " FROM public.pharmacy pharmacy" +
            " WHERE pharmacy.id = ?1"
            ,nativeQuery = true)
    MedicalInstitution getPharmacyById(Long id);

    @Query(value = "SELECT pharmacy.id AS id,pharmacy.nume AS nume, pharmacy.code AS code" +
            ", pharmacy.latitude AS latitude, pharmacy.longitude AS longitude" +
            " FROM public.pharmacy pharmacy" +
            " WHERE pharmacy.nume = ?1"
            ,nativeQuery = true)
    MedicalInstitution getPharmacyByName(String name);
}
