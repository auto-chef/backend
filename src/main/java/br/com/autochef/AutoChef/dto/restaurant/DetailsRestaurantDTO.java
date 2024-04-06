package br.com.autochef.AutoChef.dto.restaurant;

import br.com.autochef.AutoChef.model.RestaurantModel;

import java.math.BigDecimal;

public record DetailsRestaurantDTO(Long id, String name, String imageUrl, BigDecimal longitude, BigDecimal latitude) {

    public DetailsRestaurantDTO(RestaurantModel restaurant){
        this(restaurant.getId(), restaurant.getName(), restaurant.getImageUrl(), restaurant.getLatitude(), restaurant.getLongitude());
    }
}
