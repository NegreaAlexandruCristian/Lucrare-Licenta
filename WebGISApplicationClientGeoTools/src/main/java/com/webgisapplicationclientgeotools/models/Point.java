package com.webgisapplicationclientgeotools.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Point{

    private String code;
    private Long radius;
    private double latitude;
    private double longitude;
}
