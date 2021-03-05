package com.webgisapplicationclientrepository.controller;

import com.webgisapplicationclientrepository.model.TransportInstitution;
import com.webgisapplicationclientrepository.service.TransportInstitutionService;
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
@RequestMapping("/transport/locations")
@Tag(name = "TransportLocationController", description = "This controller is used to retrieve data about every " +
        "transport institution from a given city (for now is just Timisoara)")
public class TransportLocationController {

    private final TransportInstitutionService transportInstitutionService;

    @Autowired
    public TransportLocationController(TransportInstitutionService transportInstitutionService) {
        this.transportInstitutionService = transportInstitutionService;
    }


    @GetMapping("/get")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    @Operation(summary = "Retrieves all transport locations from a city.",
            description = "This method is of type GET which you can access on the endpoint of /api/transport/locations/get" +
                    " that will return every transport institution available in the database.",
            parameters = @Parameter(name = "NONE", description = "None needed"),
            responses = @ApiResponse(responseCode = "OK - 200", description = "List of transport institutions",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = TransportInstitution.class)), mediaType = "JSON"),
                    links = @Link(name = "NONE")))
    public List<TransportInstitution> getAllTransportLocations(){
        return transportInstitutionService.getAllTransportLocations();
    }

    @GetMapping("/get/{type}")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    @Operation(summary = "Retrieves a type of transport location from a city.",
            description = "This method is of type GET which you can access on the endpoint of /api/transport/locations/get/{type}" +
                    " where type represents the type of transport institution like bus stations and so on." +
                    "It will return every type of transport institution available in the database from that city.",
            parameters = @Parameter(name = "type", description = "The type of transport institution", required = true,
                    example = "api/transport/institution/get/school",
                    schema = @Schema(implementation = String.class, type = "JSON"),
                    in = ParameterIn.HEADER),
            responses = @ApiResponse(responseCode = "OK - 200", description = "List of a type of transport institution",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = TransportInstitution.class)), mediaType = "JSON"),
                    links = @Link(name = "NONE")))
    public List<TransportInstitution> getPreferredTransportLocations(@PathVariable("type") String code){
        return transportInstitutionService.getPreferredTransportLocations(code);
    }

    @GetMapping("/get/bus/station/name/{name}")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    @Operation(summary = "Retrieves a bus station location from a city by it's name from the database.",
            description = "This method is of type GET which you can access on the endpoint of /api/transport/locations/get/bus/station/name/{name}" +
                    " where code represents the type of transport institution like bus station and so on, and name represents " +
                    "the name of the transport institution.It will return the transport institution available in the database from that city by that name.",
            parameters = {@Parameter(name = "name", description = "The name of the transport institution", required = true,
                            example = "api/transport/locations/get/bus/station/Statie RATT - Bulevardul Regele Ferdinand colt cu str. Piatra Craiului",
                            schema = @Schema(implementation = String.class, type = "JSON"),
                            in = ParameterIn.HEADER)},
            responses = @ApiResponse(responseCode = "OK - 200", description = "A transport institution",
                    content = @Content(schema = @Schema(implementation = TransportInstitution.class), mediaType = "JSON"),
                    links = @Link(name = "NONE")))
    public TransportInstitution getBusStationLocationByName(@PathVariable("name") String name){
        return transportInstitutionService.getBusStationLocationByName(name);
    }

    @GetMapping("/get/bus/station/id/{id}")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    @Operation(summary = "Retrieves a bus station location from a city by it's id from the database.",
            description = "This method is of type GET which you can access on the endpoint of api/transport/locations/get/bus/station/id/{id}" +
                    " where code represents the type of transport institution like bus stations and so on, and id represents " +
                    "the id of the transport institution.It will return the transport institution available in the database from that city by that id.",
            parameters = {@Parameter(name = "id", description = "The name of the transport institution", required = true,
                            example = "api/transport/locations/get/bus/station/id/12",
                            schema = @Schema(implementation = String.class, type = "JSON"),
                            in = ParameterIn.HEADER)},
            responses = @ApiResponse(responseCode = "OK - 200", description = "A transport institution",
                    content = @Content(schema = @Schema(implementation = TransportInstitution.class), mediaType = "JSON"),
                    links = @Link(name = "NONE")))
    public TransportInstitution getBusStationLocationById(@PathVariable("id") Long id){
        return transportInstitutionService.getBusStationLocationById(id);
    }
}