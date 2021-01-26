package com.webgisapplicationclientrepository.service;

import com.webgisapplicationclientrepository.model.TransportInstitution;

import java.util.List;

public interface TransportInstitutionService {

    List<TransportInstitution> getPreferredTransportLocations(String code);

    TransportInstitution getBusStationLocationByName(String name);

    TransportInstitution getBusStationLocationById(Long id);

    List<TransportInstitution> getAllTransportLocations();
}
