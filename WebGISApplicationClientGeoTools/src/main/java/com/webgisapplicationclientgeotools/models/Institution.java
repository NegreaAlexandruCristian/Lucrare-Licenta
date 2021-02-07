package com.webgisapplicationclientgeotools.models;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Institution implements Serializable {

    private String name;
    private String code;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
