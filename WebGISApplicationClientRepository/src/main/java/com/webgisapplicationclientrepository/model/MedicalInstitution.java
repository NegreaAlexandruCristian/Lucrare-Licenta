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
@Table(name = "medical_institution")
@Schema(type = "POJO, JSON",
        description = "A POJO that holds every medical institution and because it has the 'implements Serializable'," +
                " it can be given to the web app as JSON.",
        name = "Medical Institution Object",
        example = "{\n" +
                "        \"id\": 192,\n" +
                "        \"name\": \"C. M. Dr. Fara Lucian\",\n" +
                "        \"code\": \"hospital\",\n" +
                "        \"latitude\": 45.766134681679894,\n" +
                "        \"longitude\": 21.218982373016388\n" +
                "}",
        title = "Medical Institution",
        required = true
)
public class MedicalInstitution extends BaseEntity implements Serializable {

    @Column(name = "nume")
    @Schema(name = "name",
            description = "The name field that will hold the medical institution name.",
            type = "String",
            required = true,
            example = "C. M. Dr. Fara Lucian"
    )
    private String name;

    @Column(name = "code")
    @Schema(name = "code",
            description = "The code field that will hold the medical institution type like : hospital, pharmacy etc.",
            type = "String",
            required = true,
            example = "hospital"
    )
    private String code;

    @Column(name = "latitude")
    @Schema(name = "latitude",
            description = "The latitude field that will hold the medical institution latitude.",
            type = "BigDecimal",
            required = true,
            example = "45.766134681679894"
    )
    private BigDecimal latitude;

    @Column(name = "longitude")
    @Schema(name = "longitude",
            description = "The longitude field that will hold the medical institution longitude.",
            type = "BigDecimal",
            required = true,
            example = "21.218982373016388"
    )
    private BigDecimal longitude;
}
