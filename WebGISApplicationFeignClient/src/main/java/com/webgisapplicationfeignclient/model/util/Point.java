package com.webgisapplicationfeignclient.model.util;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Point{

    private String code;
    private Long radius;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
