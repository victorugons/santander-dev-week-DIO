package dev.victorugons.santanderdevweek.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

@Getter
@Setter
public class StockDTO {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    @DecimalMin(value = "0.00")
    @Digits(integer = 6, fraction = 2)
    private Double price;

    @NotNull
    @Digits(integer = 3, fraction = 2)
    private Double variation;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;
}
