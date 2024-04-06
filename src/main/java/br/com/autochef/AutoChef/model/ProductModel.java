package br.com.autochef.AutoChef.model;

import br.com.autochef.AutoChef.dto.product.RegisterProductDTO;
import br.com.autochef.AutoChef.dto.product.UpdateProductDTO;
import br.com.autochef.AutoChef.enums.ProductCategory;
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

    @Column(name="VL_PRICE", nullable = false, precision = 5, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name="DS_CATEGORY", nullable = false)
    private ProductCategory productCategory;

    public ProductModel(RegisterProductDTO registerProduct){
        imageUrl = registerProduct.imageUrl();
        name = registerProduct.name();
        price = registerProduct.price();
        productCategory = registerProduct.category();

    }

    public void update(UpdateProductDTO updateProductDTO){
        if(updateProductDTO.imageUrl() != null) imageUrl = updateProductDTO.imageUrl();
        if(updateProductDTO.name() != null) name = updateProductDTO.name();
        if(updateProductDTO.price() != null) price = updateProductDTO.price();
    }

}
