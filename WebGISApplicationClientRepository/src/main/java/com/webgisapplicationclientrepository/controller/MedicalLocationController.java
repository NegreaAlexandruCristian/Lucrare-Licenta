package com.webgisapplicationclientrepository.controller;

import com.webgisapplicationclientrepository.model.MedicalInstitution;
import com.webgisapplicationclientrepository.service.MedicalInstitutionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.links.Link;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical/locations")
@Tag(name = "MedicalLocationController", description = "This controller is used to retrieve data about every " +
        "medical institution from a given city (for now is just Timisoara)")
public class MedicalLocationController {

    private final MedicalInstitutionService medicalInstitutionService;

    @Autowired
    public MedicalLocationController(MedicalInstitutionService medicalInstitutionService) {
        this.medicalInstitutionService = medicalInstitutionService;
    }

    @GetMapping("/get")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Retrieves all medical locations from a city.",
            description = "This method is of type GET which you can access on the endpoint of /api/medical/locations/get" +
                    "that will return every medical institution available in the database.",
                    parameters = @Parameter(name = "NONE", description = "None needed", required = false),
                    responses = @ApiResponse(responseCode = "OK - 200", description = "List of medical institutions",
                            content = @Content(schema = @Schema(implementation = MedicalInstitution.class), mediaType = "JSON"),
                    links = @Link(name = "NONE")),
                    deprecated = false)
    public List<MedicalInstitution> getAllMedicalLocations(){
        return medicalInstitutionService.getAllMedicalLocations();
    }

    @GetMapping("/get/{type}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Retrieves a type of medical location from a city.",
            description = "This method is of type GET which you can access on the endpoint of /api/medical/locations/get/{type}" +
                    "where type represents the type of medical institution like hospital and so on." +
                    "It will return every hospital institution available in the database from that city.",
            parameters = @Parameter(name = "type", description = "The type of medical institution", required = true,
                    example = "api/medical/institution/get/hospital",
            schema = @Schema(implementation = String.class, type = "JSON"),
            in = ParameterIn.HEADER),
            responses = @ApiResponse(responseCode = "OK - 200", description = "List of a type of medical institution",
                    content = @Content(schema = @Schema(implementation = MedicalInstitution.class), mediaType = "JSON"),
                    links = @Link(name = "NONE")),
            deprecated = false)
    public List<MedicalInstitution> getPreferredMedicalLocations(@PathVariable("type") String code){
        return medicalInstitutionService.getPreferredMedicalLocations(code);
    }

    //TODO Refactor the method get by name and id (make from 4 end-points just 2 by adding another path variable)

    @GetMapping("/get/hospital/name/{name}")
    @ResponseStatus(value = HttpStatus.OK)

    public MedicalInstitution getHospitalLocationByName(@PathVariable("name") String name){
        return medicalInstitutionService.getHospitalByName(name);
    }

    @GetMapping("/get/hospital/id/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public MedicalInstitution getHospitalLocationById(@PathVariable("id") Long id){
        return medicalInstitutionService.getHospitalById(id);
    }

    @GetMapping("/get/pharmacy/name/{name}")
    @ResponseStatus(value = HttpStatus.OK)
    public MedicalInstitution getPharmacyLocationByName(@PathVariable("name") String name){
        return medicalInstitutionService.getPharmacyByName(name);
    }

    @GetMapping("/get/pharmacy/id/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public MedicalInstitution getPharmacyLocationById(@PathVariable("id") Long id){
        return medicalInstitutionService.getPharmacyById(id);
    }
}
