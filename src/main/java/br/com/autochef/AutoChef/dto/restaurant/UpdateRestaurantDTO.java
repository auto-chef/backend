package br.com.autochef.AutoChef.dto.restaurant;

import br.com.autochef.AutoChef.model.RestaurantModel;

import java.math.BigDecimal;

public record UpdateRestaurantDTO(String name, String email, String password, String imageUrl,
                                  BigDecimal longitude, BigDecimal latitude) {

    public UpdateRestaurantDTO(RestaurantModel rest){
        this(rest.getName(), rest.getEmail(), rest.getPassword(), rest.getImageUrl(),
                rest.getLongitude(), rest.getLatitude());
    }
}
