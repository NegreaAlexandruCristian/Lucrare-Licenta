package com.webgisapplicationfeignclient.model.util;

import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Institution implements Serializable {

    @NotNull(message = "The id can't be null")
    private Long id;

    @NotNull(message = "The string name may not be null")
    @NotEmpty(message = "The string name may not be empty")
    @NotBlank(message = "The string name may not be blank")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
    private String name;

    @NotNull(message = "The string code may not be null")
    @NotEmpty(message = "The string code may not be empty")
    @NotBlank(message = "The string code may not be blank")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
    private String code;

    @NotNull(message = "The string latitude may not be null")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private BigDecimal latitude;

    @NotNull(message = "The string longitude may not be null")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private BigDecimal longitude;
}
