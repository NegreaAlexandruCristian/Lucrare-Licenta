package com.webgisapplicationfeignclient.model.util;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point{

    private String code;
    private Long radius;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
