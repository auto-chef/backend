package br.com.autochef.AutoChef.dto.product;

import br.com.autochef.AutoChef.controller.ProductController;
import br.com.autochef.AutoChef.model.ProductModel;
import br.com.autochef.AutoChef.model.enums.ProductCategory;

import java.math.BigDecimal;

public record RegisterProduct(String imageUrl, String name, BigDecimal price,
                              ProductCategory productCategory) {
    public RegisterProduct(ProductModel productModel){
        this(productModel.getImageUrl(), productModel.getName(), productModel.getPrice(),
                productModel.getProductCategory());
    }
}
