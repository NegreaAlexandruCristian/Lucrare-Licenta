package com.webgisapplicationclientrepository.repository;

import com.webgisapplicationclientrepository.model.User;
import com.webgisapplicationclientrepository.model.util.Institution;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface UserRepository{

    Number calculateDistance(BigDecimal fromLatitude, BigDecimal fromLongitude,
                             BigDecimal toLatitude, BigDecimal toLongitude);

    List<Institution> getLocationsFromZone(BigDecimal latitude, BigDecimal longitude,
                                           String code, Long radius);
}
