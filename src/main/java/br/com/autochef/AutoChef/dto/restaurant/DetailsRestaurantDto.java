package br.com.autochef.AutoChef.dto.restaurant;

import br.com.autochef.AutoChef.model.RestaurantModel;

import java.math.BigDecimal;

public record DetailsRestaurantDto(String name, String imageUrl, BigDecimal longitude, BigDecimal latitude) {

    public DetailsRestaurantDto(RestaurantModel rest){
        this(rest.getName(), rest.getImageUrl(), rest.getLatitude(), rest.getLongitude());
    }
}
