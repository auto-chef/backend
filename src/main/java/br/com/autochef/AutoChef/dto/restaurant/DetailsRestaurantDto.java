package br.com.autochef.AutoChef.dto.restaurant;

import br.com.autochef.AutoChef.model.RestaurantModel;

public record DetailsRestaurantDto(String name, String imageUrl, Float longitude, Float latitude) {

    public DetailsRestaurantDto(RestaurantModel rest){
        this(rest.getName(), rest.getImageUrl(), rest.getLatitude(), rest.getLongitude());
    }
}
