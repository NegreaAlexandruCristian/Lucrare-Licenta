package com.webgisapplicationclientgeotools.geotools;

import com.webgisapplicationclientgeotools.models.ObjectWrapper;

import java.math.BigDecimal;

public interface UserGeoTools {

    BigDecimal calculateDistanceBetweenTwoPoints(ObjectWrapper objectWrapper);
}
