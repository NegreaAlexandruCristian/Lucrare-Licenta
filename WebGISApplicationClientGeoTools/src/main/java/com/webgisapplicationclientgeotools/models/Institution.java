package com.webgisapplicationclientgeotools.models;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Institution implements Serializable {

    private String name;
    private String code;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
