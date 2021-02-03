package com.webgisapplicationclientrepository.model.util;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Institution {

    private String name;
    private String code;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
