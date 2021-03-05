package com.webgisapplicationfeignclientgeotools.models;

import lombok.Data;

@Data
public class Point{

    private String code;
    private Long radius;
    private double latitude;
    private double longitude;
}
