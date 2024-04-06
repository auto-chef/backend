package br.com.autochef.AutoChef.model;

import br.com.autochef.AutoChef.dto.restaurant.RegisterRestaurantDTO;
import br.com.autochef.AutoChef.dto.restaurant.UpdateRestaurantDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
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

    @Column(name="DS_IMAGE_URL",nullable = false, length = 14)
    private String imageUrl;

    @Column(name="NR_LONGITUDE",nullable = false, precision = 2, scale = 5)
    private BigDecimal longitude;

    @Column(name="NR_LATITUDE",nullable = false, precision = 2, scale = 5)
    private BigDecimal latitude;

    @Column(name="DS_EMAIL",nullable = false, length = 255)
    private String email;

    @Column(name="DS_PASSWORD",nullable = false, length = 255)
    private String password;

    public RestaurantModel(RegisterRestaurantDTO registerRestaurantDto){

        name = registerRestaurantDto.name();
        cnpj = registerRestaurantDto.cnpj();
        imageUrl = registerRestaurantDto.imageUrl();
        longitude = registerRestaurantDto.longitude();
        latitude = registerRestaurantDto.latitude();
        email = registerRestaurantDto.email();
        password = registerRestaurantDto.password();
    }

    public void update(UpdateRestaurantDTO updateRestaurantDto){
        name = updateRestaurantDto.name();
        email = updateRestaurantDto.email();
        password = updateRestaurantDto.password();
        imageUrl = updateRestaurantDto.imageUrl();
        longitude = updateRestaurantDto.longitude();
        latitude = updateRestaurantDto.latitude();
    }
}
