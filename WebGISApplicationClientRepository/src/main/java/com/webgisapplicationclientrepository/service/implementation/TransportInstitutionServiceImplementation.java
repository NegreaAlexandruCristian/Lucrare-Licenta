package com.webgisapplicationclientrepository.service.implementation;

import com.webgisapplicationclientrepository.model.TransportInstitution;
import com.webgisapplicationclientrepository.repository.TransportInstitutionRepository;
import com.webgisapplicationclientrepository.service.TransportInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportInstitutionServiceImplementation implements TransportInstitutionService {

    private final TransportInstitutionRepository transportInstitutionRepository;

    @Autowired
    public TransportInstitutionServiceImplementation(TransportInstitutionRepository transportInstitutionRepository) {
        this.transportInstitutionRepository = transportInstitutionRepository;
    }

    //Over time this method will be updated
    @Override
    public List<TransportInstitution> getPreferredTransportLocations(String code) {
        if(code.equalsIgnoreCase("bus-stop")){

            return transportInstitutionRepository.getBusStationLocations();
        }
        return null;
    }

    @Override
    public TransportInstitution getBusStationLocationByName(String name) {
        return transportInstitutionRepository.getBusStationLocationByName(name);
    }

    @Override
    public TransportInstitution getBusStationLocationById(Long id) {
        return transportInstitutionRepository.getBusStationLocationById(id);
    }

    //Over time this method will be updated
    @Override
    public List<TransportInstitution> getAllTransportLocations() {

        return transportInstitutionRepository.getBusStationLocations();
    }
}
