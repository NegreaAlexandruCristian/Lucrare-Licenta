package com.webgisapplicationclientgeotools.models;

import lombok.*;
import org.locationtech.jts.geom.Geometry;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Point{

    private String code;
    private Long radius;
    private double latitude;
    private double longitude;
}
