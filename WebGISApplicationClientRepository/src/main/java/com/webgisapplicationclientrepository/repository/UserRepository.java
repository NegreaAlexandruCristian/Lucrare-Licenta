package com.webgisapplicationclientrepository.repository;

import com.webgisapplicationclientrepository.model.User;
import com.webgisapplicationclientrepository.model.util.Institution;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
@Transactional
public interface UserRepository  extends CrudRepository<User, Long> {

    @Query(value = "SELECT calculate_distance(?1, ?2, ?3, ?4, 'K')"
            ,nativeQuery = true)
    BigDecimal getDistance(BigDecimal fromLatitude, BigDecimal fromLongitude,
                           BigDecimal toLatitude, BigDecimal toLongitude);

    //TODO Not working, don't know what to do...
    @Query(value = "SELECT zone.nume, zone.code, zone.latitude, zone.longitude " +
            "FROM public.?3 zone " +
            "WHERE ST_DWithin(ST_MakePoint(?1,?2),zone.geom,?4)"
            ,nativeQuery = true)
    Institution getLocationsFromZone(BigDecimal latitude, BigDecimal longitude,
                                     String code, Integer radius);
}
