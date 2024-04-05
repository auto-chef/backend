package br.com.autochef.AutoChef.dto.product;

import br.com.autochef.AutoChef.enums.ProductCategory;
import br.com.autochef.AutoChef.model.ProductModel;

import java.math.BigDecimal;

public record DetailsProductDTO(String imageUrl, String name, BigDecimal price,
                                ProductCategory productCategory) {
    public DetailsProductDTO(ProductModel productModel){
        this(productModel.getImageUrl(), productModel.getName(), productModel.getPrice(),
                productModel.getProductCategory());
    }
}
