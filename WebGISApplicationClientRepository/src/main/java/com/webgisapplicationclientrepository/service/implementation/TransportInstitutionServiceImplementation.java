package com.webgisapplicationclientrepository.service.implementation;

import com.webgisapplicationclientrepository.exceptions.NotAllowedException;
import com.webgisapplicationclientrepository.exceptions.NotFoundException;
import com.webgisapplicationclientrepository.model.TransportInstitution;
import com.webgisapplicationclientrepository.repository.TransportInstitutionRepository;
import com.webgisapplicationclientrepository.service.TransportInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

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

        code = code.toLowerCase();
        switch (code){
            case "bus-stop":{
                return transportInstitutionRepository.getBusStationLocations();
            }
            default:{
                throw new NotAllowedException();
            }
        }
    }

    @Override
    public TransportInstitution getBusStationLocationByName(String name) {

        //this will change in time as the application grows
        String code = "bus-stop";
        switch (code){
            case "bus-stop":{
                TransportInstitution transportInstitution =
                        transportInstitutionRepository.getBusStationLocationByName(name);
                if(transportInstitution == null){
                    throw new NotFoundException();
                } else {
                    return transportInstitution;
                }
            }
            default:{
                throw new NotAllowedException();
            }
        }
    }

    @Override
    public TransportInstitution getBusStationLocationById(Long id) {
        String code = "bus-stop";
        switch (code){
            case "bus-stop":{
                TransportInstitution transportInstitution =
                        transportInstitutionRepository.getBusStationLocationById(id);
                if(transportInstitution == null){
                    throw new NotFoundException();
                } else {
                    return transportInstitution;
                }
            }
            default:{
                throw new NotAllowedException();
            }
        }
    }

    //Over time this method will be updated
    @Override
    public List<TransportInstitution> getAllTransportLocations() {

        return transportInstitutionRepository.getBusStationLocations();
    }
}
