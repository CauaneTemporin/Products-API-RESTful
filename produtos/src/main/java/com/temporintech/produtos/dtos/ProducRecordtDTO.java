package com.temporintech.produtos.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProducRecordtDTO(@NotBlank String name, @NotNull BigDecimal value) {

}