package br.com.autochef.AutoChef.dto.product;

import br.com.autochef.AutoChef.enums.ProductCategory;
import br.com.autochef.AutoChef.model.ProductModel;

import java.math.BigDecimal;

public record DetailsProductDTO(Long id, String imageUrl, String name, BigDecimal price, ProductCategory category) {
    public DetailsProductDTO(ProductModel product){
        this(product.getId(), product.getImageUrl(), product.getName(), product.getPrice(), product.getProductCategory());
    }
}
