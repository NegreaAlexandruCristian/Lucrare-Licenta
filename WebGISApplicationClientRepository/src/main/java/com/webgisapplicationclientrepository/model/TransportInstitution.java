package com.webgisapplicationclientrepository.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "transport_institution")
@Schema(type = "POJO, JSON",
        description = "A POJO that holds every transport institution and because it has the 'implements Serializable'," +
                " it can be given to the web app as JSON.",
        name = "Transport Institution Object",
        example = "{\n" +
                "        \"id\": 189,\n" +
                "        \"name\": \"Statie RATT - Calea Torontalului retur\",\n" +
                "        \"code\": \"bus-stop\",\n" +
                "        \"latitude\": 45.76915045209458,\n" +
                "        \"longitude\": 21.2196600391826\n" +
                "}",
        title = "Public Institution",
        required = true
)
public class TransportInstitution extends BaseEntity implements Serializable{

    @Column(name = "nume")
    @Schema(name = "name",
            description = "The name field that will hold the transport institution name.",
            type = "String",
            required = true,
            example = "Statie RATT - Calea Torontalului retur"
    )
    private String name;

    @Column(name = "code")
    @Schema(name = "code",
            description = "The code field that will hold the transport institution type like : bus-stop etc.",
            type = "String",
            required = true,
            example = "bus-stop"
    )
    private String code;

    @Column(name = "latitude")
    @Schema(name = "latitude",
            description = "The latitude field that will hold the transport institution latitude.",
            type = "BigDecimal",
            required = true,
            example = "45.766134681679894"
    )
    private BigDecimal latitude;

    @Column(name = "longitude")
    @Schema(name = "longitude",
            description = "The longitude field that will hold the transport institution longitude.",
            type = "BigDecimal",
            required = true,
            example = "21.218982373016388"
    )
    private BigDecimal longitude;
}
