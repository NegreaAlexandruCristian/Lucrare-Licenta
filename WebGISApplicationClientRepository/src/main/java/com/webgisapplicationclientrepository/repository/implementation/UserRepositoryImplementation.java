package com.webgisapplicationclientrepository.repository.implementation;

import com.webgisapplicationclientrepository.model.util.Institution;
import com.webgisapplicationclientrepository.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImplementation implements UserRepository {

    private final EntityManager entityManager;

    @Autowired
    public UserRepositoryImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Number calculateDistance(BigDecimal fromLatitude, BigDecimal fromLongitude, BigDecimal toLatitude,
                                    BigDecimal toLongitude) {
        return (Number) entityManager.createNativeQuery("SELECT calculate_distance(" + fromLatitude +", " + fromLongitude +
                ", " + toLatitude +", " + toLongitude +", 'K')").getSingleResult();
    }

    @Override
    public List<Institution> getLocationsFromZone(BigDecimal latitude, BigDecimal longitude, String code, Long radius) {
        Query query = entityManager.createNativeQuery(
                "SELECT table_name.id AS id, table_name.nume AS name, table_name.code AS code, ST_X(table_name.geom) AS latitude, ST_Y(table_name.geom) AS longitude" +
                " FROM " + code + " AS table_name " +
                        " WHERE ST_PointInsideCircle(table_name.geom, " + latitude + "," + longitude +"," + radius +" * 0.00001);", Institution.class);
        return query.getResultList();
    }
}
