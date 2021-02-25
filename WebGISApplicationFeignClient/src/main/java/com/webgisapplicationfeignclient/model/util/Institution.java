package com.webgisapplicationfeignclient.model.util;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Institution implements Serializable {

    private Long id;
    private String name;
    private String code;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
