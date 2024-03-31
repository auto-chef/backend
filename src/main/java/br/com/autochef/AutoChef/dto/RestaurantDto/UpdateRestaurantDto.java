package br.com.autochef.AutoChef.dto.RestaurantDto;

import br.com.autochef.AutoChef.model.Restaurant;

public record UpdateRestaurantDto(String name, String email, String password, String imageUrl,
                                  Float longitude, Float latitude) {

    public UpdateRestaurantDto (Restaurant rest){
        this(rest.getName(), rest.getEmail(), rest.getPassword(), rest.getImageUrl(),
                rest.getLongitude(), rest.getLatitude());
    }
}
