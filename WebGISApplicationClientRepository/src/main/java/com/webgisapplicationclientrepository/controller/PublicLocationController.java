package com.webgisapplicationclientrepository.controller;

import com.webgisapplicationclientrepository.model.PublicInstitution;
import com.webgisapplicationclientrepository.service.PublicInstitutionService;
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
@RequestMapping("/public/locations")
@Tag(name = "PublicLocationController", description = "This controller is used to retrieve data about every " +
        "public institution from a given city (for now is just Timisoara)")
public class PublicLocationController {

    private final PublicInstitutionService publicInstitutionService;

    @Autowired
    public PublicLocationController(PublicInstitutionService publicInstitutionService) {
        this.publicInstitutionService = publicInstitutionService;
    }

    @GetMapping("/get")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    @Operation(summary = "Retrieves all public locations from a city.",
            description = "This method is of type GET which you can access on the endpoint of /api/public/locations/get" +
                    " that will return every public institution available in the database.",
            parameters = @Parameter(name = "NONE", description = "None needed", required = false),
            responses = @ApiResponse(responseCode = "OK - 200", description = "List of public institutions",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = PublicInstitution.class)), mediaType = "JSON"),
                    links = @Link(name = "NONE")),
            deprecated = false)
    public List<PublicInstitution> getAllPublicLocations(){
        return publicInstitutionService.getAllPublicLocations();
    }

    @GetMapping("/get/{type}")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    @Operation(summary = "Retrieves a type of public location from a city.",
            description = "This method is of type GET which you can access on the endpoint of /api/public/locations/get/{type}" +
                    " where type represents the type of public institution like hospital and so on." +
                    "It will return every type of public institution available in the database from that city.",
            parameters = @Parameter(name = "type", description = "The type of public institution", required = true,
                    example = "api/public/institution/get/school",
                    schema = @Schema(implementation = String.class, type = "JSON"),
                    in = ParameterIn.HEADER),
            responses = @ApiResponse(responseCode = "OK - 200", description = "List of a type of public institution",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = PublicInstitution.class)), mediaType = "JSON"),
                    links = @Link(name = "NONE")),
            deprecated = false)
    public List<PublicInstitution> getPreferredPublicLocations(@PathVariable("type") String code){
        return publicInstitutionService.getPreferredPublicLocations(code);
    }

    @GetMapping("/get/{code}/name/{name}")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    @Operation(summary = "Retrieves a type of public location from a city by it's name from the database.",
            description = "This method is of type GET which you can access on the endpoint of /api/public/locations/get/{code}/name/{name}" +
                    " where code represents the type of public institution like school, university and so on, and name represents " +
                    "the name of the public institution.It will return the public institution available in the database from that city by that name.",
            parameters = {@Parameter(name = "code", description = "The type of public institution", required = true,
                    example = "api/public/institution/get/school/name/{name}",
                    schema = @Schema(implementation = String.class, type = "JSON"),
                    in = ParameterIn.HEADER),
                          @Parameter(name = "name", description = "The name of the public institution", required = true,
                            example = "api/public/institution/get/school/name/Centrul Scolar Pentru Educatie Incluziva Constantin Pufan",
                            schema = @Schema(implementation = String.class, type = "JSON"),
                            in = ParameterIn.HEADER)},
            responses = @ApiResponse(responseCode = "OK - 200", description = "A public institution",
                    content = @Content(schema = @Schema(implementation = PublicInstitution.class), mediaType = "JSON"),
                    links = @Link(name = "NONE")),
            deprecated = false)
    public PublicInstitution getPublicInstitutionLocationByName(@PathVariable("code") String code,
                                                     @PathVariable("name") String name){
        return publicInstitutionService.getPublicInstitutionByName(code, name);
    }

    @GetMapping("/get/{code}/id/{id}")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    @Operation(summary = "Retrieves a type of public location from a city by it's id from the database.",
            description = "This method is of type GET which you can access on the endpoint of /api/public/locations/get/{code}/id/{id}" +
                    " where code represents the type of public institution like school, university and so on, and id represents " +
                    "the id of the public institution.It will return the public institution available in the database from that city by that id.",
            parameters = {@Parameter(name = "code", description = "The type of public institution", required = true,
                    example = "api/public/institution/get/school/id/{id}",
                    schema = @Schema(implementation = String.class, type = "JSON"),
                    in = ParameterIn.HEADER),
                    @Parameter(name = "id", description = "The name of the public institution", required = true,
                            example = "api/public/institution/get/hospital/id/12",
                            schema = @Schema(implementation = String.class, type = "JSON"),
                            in = ParameterIn.HEADER)},
            responses = @ApiResponse(responseCode = "OK - 200", description = "A public institution",
                    content = @Content(schema = @Schema(implementation = PublicInstitution.class), mediaType = "JSON"),
                    links = @Link(name = "NONE")),
            deprecated = false)
    public PublicInstitution getPublicInstitutionLocationById(@PathVariable("code") String code,
                                                   @PathVariable("id") Long id){
        return publicInstitutionService.getPublicInstitutionById(code, id);
    }
}
