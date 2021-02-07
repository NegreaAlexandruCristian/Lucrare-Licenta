package com.webgisapplicationclientgeotools.services;

import com.webgisapplicationclientgeotools.models.ObjectWrapper;

import java.math.BigDecimal;

public interface UserService {
    BigDecimal calculateDistanceBetweenTwoPoints(ObjectWrapper objectWrapper);
}
