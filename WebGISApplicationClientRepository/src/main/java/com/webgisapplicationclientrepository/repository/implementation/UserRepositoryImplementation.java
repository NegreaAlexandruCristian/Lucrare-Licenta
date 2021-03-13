package com.webgisapplicationclientrepository.repository.implementation;

import com.webgisapplicationclientrepository.model.util.Institution;
import com.webgisapplicationclientrepository.model.util.Point;
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

    //TODO sa calculeze in functie si de strazi/trotuar
    //TODO To try to use ST_DistanceSphere instead of the built in function
//    @Override
//    public BigDecimal calculateDistance(BigDecimal fromLatitude, BigDecimal fromLongitude, BigDecimal toLatitude,
//                                    BigDecimal toLongitude) {
//        return BigDecimal.valueOf((Double) entityManager.createNativeQuery("SELECT calculate_distance(" + fromLatitude +", " + fromLongitude +
//                ", " + toLatitude +", " + toLongitude +", 'K')").getSingleResult());
//    }

    @Override
    public BigDecimal calculateDistance(BigDecimal fromLatitude, BigDecimal fromLongitude, BigDecimal toLatitude, BigDecimal toLongitude) {
        return BigDecimal.valueOf((Double)entityManager.createNativeQuery("" +
                "SELECT ST_DistanceSphere(ST_MakePoint(" + fromLongitude + ", " + fromLatitude + ")," +
                "ST_MakePoint(" + toLongitude + ", " + toLatitude +"));").getSingleResult());
    }

    @Override
    public List<Institution> getLocationsFromZone(BigDecimal latitude, BigDecimal longitude, String code, Long radius) {
        Query query = entityManager.createNativeQuery(
                "SELECT table_name.id AS id, table_name.nume AS name, table_name.code AS code, ST_X(table_name.geom) AS longitude, ST_Y(table_name.geom) AS latitude" +
                " FROM " + code + " AS table_name " +
                        "WHERE ST_DWithin(table_name.geom," + "ST_GeogFromText('POINT(" + longitude  + " " + latitude + ")'), " + radius + ")"
                        /*" WHERE ST_PointInsideCircle(table_name.geom, " + longitude + "," + latitude +"," + radius +" * 0.00001);"*/ , Institution.class);
        return  query.getResultList();
    }

    //TODO sa calculeze in functie si de strazi/trotuar
    @Override
    public Institution getShortestLocationFromZone(Point point) {
        Query query = entityManager.createNativeQuery(
                "SELECT table_name.id AS id, table_name.nume AS name, table_name.code AS code," +
                        " ST_X(table_name.geom) AS longitude, ST_Y(table_name.geom) AS latitude FROM " + point.getCode()
                        + " AS table_name WHERE ST_Distance(table_name.geom, ST_SetSRID(ST_GeogFromText('POINT(" +
                        point.getLongitude() + " "+ point.getLatitude() + ")'), 4326), true)" +
                        "=(SELECT MIN(ST_Distance(geom, ST_SetSRID(ST_GeogFromText('POINT(" + point.getLongitude() + " " +
                        point.getLatitude() + ")'), 4326), true)) FROM " + point.getCode() + ");"
        ,Institution.class);
        return (Institution) query.getSingleResult();
    }
}
