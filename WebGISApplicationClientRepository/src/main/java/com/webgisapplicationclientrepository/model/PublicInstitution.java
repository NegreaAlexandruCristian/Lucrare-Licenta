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
@Table(name = "public_institution")
@Schema(type = "POJO, JSON",
        description = "A POJO that holds every public institution and because it has the 'implements Serializable'," +
                " it can be given to the web app as JSON.",
        name = "Public Institution Object",
        example = "{\n" +
                "        \"id\": 47,\n" +
                "        \"name\": \"Scoala Generala nr. 26\",\n" +
                "        \"code\": \"school\",\n" +
                "        \"latitude\": 45.766180493702095,\n" +
                "        \"longitude\": 21.21715439590912\n" +
                "}",
        title = "Public Institution",
        required = true
)
public class PublicInstitution extends BaseEntity implements Serializable {

    @Column(name = "nume")
    @Schema(name = "name",
            description = "The name field that will hold the public institution name.",
            type = "String",
            required = true,
            example = "Scoala Generala nr. 26"
    )
    private String name;

    @Column(name = "code")
    @Schema(name = "code",
            description = "The code field that will hold the public institution type like : school, university etc.",
            type = "String",
            required = true,
            example = "school"
    )
    private String code;

    @Column(name = "latitude")
    @Schema(name = "latitude",
            description = "The latitude field that will hold the public institution latitude.",
            type = "BigDecimal",
            required = true,
            example = "45.766134681679894"
    )
    private BigDecimal latitude;

    @Column(name = "longitude")
    @Schema(name = "longitude",
            description = "The longitude field that will hold the public institution longitude.",
            type = "BigDecimal",
            required = true,
            example = "21.218982373016388"
    )
    private BigDecimal longitude;
}
