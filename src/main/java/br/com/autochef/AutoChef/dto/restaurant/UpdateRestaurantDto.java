package br.com.autochef.AutoChef.dto.restaurant;

import br.com.autochef.AutoChef.model.RestaurantModel;

import java.math.BigDecimal;

public record UpdateRestaurantDto(String name, String email, String password, String imageUrl,
                                  BigDecimal longitude, BigDecimal latitude) {

    public UpdateRestaurantDto (RestaurantModel rest){
        this(rest.getName(), rest.getEmail(), rest.getPassword(), rest.getImageUrl(),
                rest.getLongitude(), rest.getLatitude());
    }
}
