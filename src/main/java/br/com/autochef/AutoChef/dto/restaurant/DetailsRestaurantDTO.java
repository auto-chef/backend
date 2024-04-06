package br.com.autochef.AutoChef.dto.restaurant;

import br.com.autochef.AutoChef.model.RestaurantModel;

import java.math.BigDecimal;

public record DetailsRestaurantDTO(String name, String imageUrl, BigDecimal longitude, BigDecimal latitude) {

    public DetailsRestaurantDTO(RestaurantModel rest){
        this(rest.getName(), rest.getImageUrl(), rest.getLatitude(), rest.getLongitude());
    }
}
