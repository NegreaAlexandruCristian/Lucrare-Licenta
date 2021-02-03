package com.webgisapplicationclientrepository.model.util;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Point {

    private String code;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
