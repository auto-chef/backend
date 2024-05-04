package br.com.autochef.AutoChef.dto.product;

import br.com.autochef.AutoChef.enums.ProductCategory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;

public record RegisterProductDTO(
        @NotBlank @Size(max = 255)
        String imageUrl,

        @NotBlank @Size(max = 255)
        String name,

        @NotNull @DecimalMin(value = "0.0", inclusive = false)
        BigDecimal price,

        ProductCategory category
) {
}