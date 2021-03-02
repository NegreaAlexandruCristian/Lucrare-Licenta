package com.webgisapplicationclientrepository.model.util;

import com.webgisapplicationclientrepository.model.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Institution extends BaseEntity implements Serializable {

    private String name;
    private String code;
    private BigDecimal latitude;
    private BigDecimal longitude;
}