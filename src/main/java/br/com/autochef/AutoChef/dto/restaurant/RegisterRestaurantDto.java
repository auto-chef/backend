package br.com.autochef.AutoChef.dto.restaurant;

import br.com.autochef.AutoChef.model.RestaurantModel;

public record RegisterRestaurantDto(String name, String cnpj, String imageUrl, Float longitude,
                                    Float latitude, String email, String password) {

    public RegisterRestaurantDto(RestaurantModel restaurant){

        this(restaurant.getName(), restaurant.getCnpj(), restaurant.getImageUrl(), restaurant.getLongitude(),
                restaurant.getLatitude(), restaurant.getEmail(), restaurant.getPassword());
    }
}
