package com.webgisapplicationclientrepository.dto.builder;

import com.webgisapplicationclientrepository.dto.MedicalInstitutionDTO;

import java.math.BigDecimal;

public class MedicalInstitutionDTOBuilder {

    private String name;
    private String code;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public static MedicalInstitutionDTOBuilder builder(){
        return new MedicalInstitutionDTOBuilder();
    }

    public MedicalInstitutionDTOBuilder name(String name){
        this.name = name;
        return this;
    }

    public MedicalInstitutionDTOBuilder code(String code){
        this.code = code;
        return this;
    }

    public MedicalInstitutionDTOBuilder latitude(BigDecimal latitude){
        this.latitude = latitude;
        return this;
    }

    public MedicalInstitutionDTOBuilder longitude(BigDecimal longitude){
        this.longitude = longitude;
        return this;
    }

    public MedicalInstitutionDTO build(){
        MedicalInstitutionDTO medicalInstitutionDTO = new MedicalInstitutionDTO();

        medicalInstitutionDTO.setCode(code);
        medicalInstitutionDTO.setName(name);
        medicalInstitutionDTO.setLatitude(latitude);
        medicalInstitutionDTO.setLongitude(longitude);

        return medicalInstitutionDTO;
    }
}
