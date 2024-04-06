package br.com.autochef.AutoChef.dto.product;

import br.com.autochef.AutoChef.model.ProductModel;
import br.com.autochef.AutoChef.enums.ProductCategory;

import java.math.BigDecimal;

public record RegisterProductDTO(String imageUrl, String name, BigDecimal price, ProductCategory category) {
}
