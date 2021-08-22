package dev.victorugons.santanderdevweek.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

@Getter
@Setter
public class StockDTO {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "StockA")
    @NotNull
    private String name;

    @Schema(example = "10.00")
    @NotNull
    @DecimalMin(value = "0.00")
    @Digits(integer = 6, fraction = 2)
    private Double price;

    @Schema(example = "10.00")
    @NotNull
    @Digits(integer = 3, fraction = 2)
    private Double variation;

    @Schema(example = "01/01/2001")
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;
}
