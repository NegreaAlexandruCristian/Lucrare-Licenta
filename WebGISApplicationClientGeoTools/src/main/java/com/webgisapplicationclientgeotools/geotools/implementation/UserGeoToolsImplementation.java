package com.webgisapplicationclientgeotools.geotools.implementation;

import com.webgisapplicationclientgeotools.geotools.UserGeoTools;
import com.webgisapplicationclientgeotools.models.ObjectWrapper;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.GeodeticCalculator;
import org.locationtech.jts.geom.Coordinate;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.TransformException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UserGeoToolsImplementation implements UserGeoTools {

    @Override
    public BigDecimal calculateDistanceBetweenTwoPoints(ObjectWrapper objectWrapper){

        double distance = 0.0;
        try {
            Coordinate start = new Coordinate(objectWrapper.getStartingDistance().getLatitude(),
                    objectWrapper.getStartingDistance().getLongitude());
            Coordinate end = new Coordinate(objectWrapper.getFinishDestination().getLatitude(),
                    objectWrapper.getFinishDestination().getLongitude());

            CoordinateReferenceSystem crs = null;
            try {
                crs = CRS.decode("epsg:4326");
            } catch (FactoryException e) {
                e.printStackTrace();
            }
            GeodeticCalculator gc = new GeodeticCalculator(crs);
            gc.setStartingPosition(JTS.toDirectPosition(start, crs));
            gc.setDestinationPosition(JTS.toDirectPosition(end, crs));

            double totalMeters = gc.getOrthodromicDistance();
            distance = totalMeters / 1000;

        } catch (TransformException exception){
            exception.printStackTrace();
        }

        return BigDecimal.valueOf(distance);
    }
}
