package com.webgisapplicationfeignclient.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PublicInstitution{

    private Long id;
    private String name;
    private String code;
    private BigDecimal latitude;
    private BigDecimal longitude;

}
