package com.webgisapplicationclientrepository.controller;

import com.webgisapplicationclientrepository.model.MedicalInstitution;
import com.webgisapplicationclientrepository.service.MedicalInstitutionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.links.Link;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    @Operation(summary = "Retrieves all medical locations from a city.",
            description = "This method is of type GET which you can access on the endpoint of /api/medical/locations/get" +
                    "that will return every medical institution available in the database.",
                    parameters = @Parameter(name = "NONE", description = "None needed"),
                    responses = @ApiResponse(responseCode = "OK - 200", description = "List of medical institutions",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MedicalInstitution.class)), mediaType = "JSON"),
                    links = @Link(name = "NONE")))
    public List<MedicalInstitution> getAllMedicalLocations(){
        return medicalInstitutionService.getAllMedicalLocations();
    }

    @GetMapping("/get/{type}")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    @Operation(summary = "Retrieves a type of medical location from a city.",
            description = "This method is of type GET which you can access on the endpoint of /api/medical/locations/get/{type}" +
                    "where type represents the type of medical institution like hospital and so on." +
                    "It will return every given type of medical institution available in the database from that city.",
            parameters = @Parameter(name = "type", description = "The type of medical institution", required = true,
                    example = "api/medical/institution/get/hospital",
            schema = @Schema(implementation = String.class, type = "JSON"),
            in = ParameterIn.HEADER),
            responses = @ApiResponse(responseCode = "OK - 200", description = "List of a type of medical institution",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = MedicalInstitution.class)), mediaType = "JSON"),
                    links = @Link(name = "NONE")))
    public List<MedicalInstitution> getPreferredMedicalLocations(@PathVariable("type") String code){
        return medicalInstitutionService.getPreferredMedicalLocations(code);
    }

    @GetMapping("/get/{code}/name/{name}")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    @Operation(summary = "Retrieves a type of medical location from a city by it's name from the database.",
            description = "This method is of type GET which you can access on the endpoint of /api/medical/locations/get/{code}/name/{name}" +
                    " where code represents the type of medical institution like hospital, pharmacy and so on, and name represents " +
                    "the name of the medical institution.It will return the medical institution available in the database from that city by that name.",
            parameters = {@Parameter(name = "code", description = "The type of medical institution", required = true,
                    example = "api/medical/institution/get/hospital/name/{name}",
                    schema = @Schema(implementation = String.class, type = "JSON"),
                    in = ParameterIn.HEADER),
                          @Parameter(name = "name", description = "The name of the medical institution", required = true,
                                  example = "api/medical/institution/get/hospital/name/Policlinica Sanatatea",
                                  schema = @Schema(implementation = String.class, type = "JSON"),
                                  in = ParameterIn.HEADER)},
            responses = @ApiResponse(responseCode = "OK - 200", description = "A medical institution",
                    content = @Content(schema = @Schema(implementation = MedicalInstitution.class), mediaType = "JSON"),
                    links = @Link(name = "NONE")))
    public MedicalInstitution getMedicalInstitutionLocationByName(@PathVariable(name = "code") String code,
                                                        @PathVariable(name = "name") String name){
        return medicalInstitutionService.getMedicalInstitutionByName(code,name);
    }

    @GetMapping("/get/{code}/id/{id}")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    @Operation(summary = "Retrieves a type of medical location from a city by it's id from the database.",
            description = "This method is of type GET which you can access on the endpoint of /api/medical/locations/get/{code}/id/{id}" +
                    " where code represents the type of medical institution like hospital, pharmacy and so on, and id represents " +
                    "the id of the medical institution.It will return the medical institution available in the database from that city by that id.",
            parameters = {@Parameter(name = "code", description = "The type of medical institution", required = true,
                    example = "api/medical/institution/get/hospital/id/{id}",
                    schema = @Schema(implementation = String.class, type = "JSON"),
                    in = ParameterIn.HEADER),
                          @Parameter(name = "id", description = "The name of the medical institution", required = true,
                            example = "api/medical/institution/get/hospital/id/12",
                            schema = @Schema(implementation = String.class, type = "JSON"),
                            in = ParameterIn.HEADER)},
            responses = @ApiResponse(responseCode = "OK - 200", description = "A medical institution",
                    content = @Content(schema = @Schema(implementation = MedicalInstitution.class), mediaType = "JSON"),
                    links = @Link(name = "NONE")))
    public MedicalInstitution getMedicalInstitutionLocationById(@PathVariable(name = "code") String code,
                                                                @PathVariable("id") Long id){
        return medicalInstitutionService.getMedicalInstitutionById(code,id);
    }
}
