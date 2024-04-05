package br.com.autochef.AutoChef.dto.restaurant;

import br.com.autochef.AutoChef.model.RestaurantModel;

import java.math.BigDecimal;

public record RegisterRestaurantDto(String name, String cnpj, String imageUrl, BigDecimal longitude,
                                    BigDecimal latitude, String email, String password) {

    public RegisterRestaurantDto(RestaurantModel restaurant){

        this(restaurant.getName(), restaurant.getCnpj(), restaurant.getImageUrl(), restaurant.getLongitude(),
                restaurant.getLatitude(), restaurant.getEmail(), restaurant.getPassword());
    }
}
