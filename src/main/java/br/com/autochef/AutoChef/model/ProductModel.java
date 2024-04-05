package br.com.autochef.AutoChef.model;

import br.com.autochef.AutoChef.dto.product.RegisterProduct;
import br.com.autochef.AutoChef.model.enums.ProductCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name="TB_PRODUCT")
public class ProductModel {

    @Id
    @GeneratedValue
    @Column(name="ID_PRODUCT")
    private Long id;

    @Column(name="NM_PRODUCT", nullable = false, length = 255)
    private String name;

    @Column(name="DS_IMAGE_URL", nullable = false, length = 255)
    private String imageUrl;

    @Column(name="VL_PRICE", nullable = false, precision = 3, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name="DS_CATEGORY", nullable = false, length = 255)
    private ProductCategory productCategory;

    public ProductModel(RegisterProduct registerProduct){
        imageUrl = registerProduct.imageUrl();
        name = registerProduct.name();
        price = registerProduct.price();
        productCategory = registerProduct.productCategory();
    }

}
