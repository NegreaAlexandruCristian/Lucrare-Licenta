package com.webgisapplicationfeignclientgeotools.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institution implements Serializable {

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
