package br.com.autochef.AutoChef.model;

import br.com.autochef.AutoChef.dto.restaurant.RegisterRestaurantDTO;
import br.com.autochef.AutoChef.dto.restaurant.UpdateRestaurantDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TB_RESTAURANT")
public class RestaurantModel {
    @Id
    @GeneratedValue
    @Column(name="ID_RESTAURANT")
    private Long id;

    @Column(name="NM_RESTAURANT",nullable = false, length = 255)
    private String name;

    @Column(name="NR_CNPJ",nullable = false, length = 14)
    private String cnpj;

    @Column(name="DS_IMAGE_URL",nullable = false)
    private String imageUrl;

    @Column(name="NR_LONGITUDE",nullable = false, precision = 18, scale = 16)
    private BigDecimal longitude;

    @Column(name="NR_LATITUDE",nullable = false, precision = 18, scale = 16)
    private BigDecimal latitude;

    @Column(name="DS_EMAIL",nullable = false, length = 255)
    private String email;

    @Column(name="DS_PASSWORD",nullable = false, length = 255)
    private String password;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<OrderModel> orders;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<ProductModel> products = new ArrayList<>();

    public RestaurantModel(ProductModel productModel){
        this.products.add(productModel);
    }

    public RestaurantModel(RegisterRestaurantDTO registerRestaurantDto){
        this.name = registerRestaurantDto.name();
        this.cnpj = registerRestaurantDto.cnpj();
        this.imageUrl = registerRestaurantDto.imageUrl();
        this.longitude = registerRestaurantDto.longitude();
        this.latitude = registerRestaurantDto.latitude();
        this.email = registerRestaurantDto.email();
        this.password = registerRestaurantDto.password();
    }

    public void update(UpdateRestaurantDTO updateRestaurantDto){
        if(updateRestaurantDto.name() != null) this.name = updateRestaurantDto.name();
        if(updateRestaurantDto.email() != null) this.email = updateRestaurantDto.email();
        if(updateRestaurantDto.password() != null) this.password = updateRestaurantDto.password();
        if(updateRestaurantDto.imageUrl() != null) this.imageUrl = updateRestaurantDto.imageUrl();
        if(updateRestaurantDto.longitude() != null) this.longitude = updateRestaurantDto.longitude();
        if(updateRestaurantDto.latitude() != null) this.latitude = updateRestaurantDto.latitude();
    }
}
