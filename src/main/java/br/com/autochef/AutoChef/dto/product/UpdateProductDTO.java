package br.com.autochef.AutoChef.dto.product;

import br.com.autochef.AutoChef.enums.ProductCategory;
import br.com.autochef.AutoChef.model.ProductModel;

import java.math.BigDecimal;

public record UpdateProductDTO (String imageUrl, String name, BigDecimal price){

    public UpdateProductDTO(ProductModel productModel){
        this(productModel.getImageUrl(), productModel.getName(), productModel.getPrice());
    }
}
