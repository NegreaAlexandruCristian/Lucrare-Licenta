package com.webgisapplicationclientrepository.controller;

import com.webgisapplicationclientrepository.model.MedicalInstitution;
import com.webgisapplicationclientrepository.service.MedicalInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medical/locations")
public class MedicalLocationController {

    private final MedicalInstitutionService medicalInstitutionService;

    @Autowired
    public MedicalLocationController(MedicalInstitutionService medicalInstitutionService) {
        this.medicalInstitutionService = medicalInstitutionService;
    }

    @GetMapping("/get")
    public List<MedicalInstitution> getAllMedicalLocations(){
        return medicalInstitutionService.getAllMedicalLocations();
    }

    @GetMapping("/get/{type}")
    public List<MedicalInstitution> getPreferredMedicalLocations(@PathVariable("type") String code){
        return medicalInstitutionService.getPreferredMedicalLocations(code);
    }

    @GetMapping("/get/hospital/name/{name}")
    public MedicalInstitution getHospitalLocationByName(@PathVariable("name") String name){
        return medicalInstitutionService.getHospitalByName(name);
    }

    @GetMapping("/get/hospital/id/{id}")
    public MedicalInstitution getHospitalLocationById(@PathVariable("id") Long id){
        return medicalInstitutionService.getHospitalById(id);
    }

    @GetMapping("/get/pharmacy/name/{name}")
    public MedicalInstitution getPharmacyLocationByName(@PathVariable("name") String name){
        return medicalInstitutionService.getPharmacyByName(name);
    }

    @GetMapping("/get/pharmacy/id/{id}")
    public MedicalInstitution getPharmacyLocationById(@PathVariable("id") Long id){
        return medicalInstitutionService.getPharmacyById(id);
    }
}
