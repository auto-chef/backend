package br.com.autochef.AutoChef.dto.product;

import br.com.autochef.AutoChef.enums.ProductCategory;
import br.com.autochef.AutoChef.model.ProductModel;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record UpdateProductDTO (

        @Size(max=255)
        String imageUrl,
        @Size(max=255)
        String name,
        @DecimalMin(value = "0.0", inclusive = false)
        BigDecimal price) {

}
