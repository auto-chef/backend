package br.com.autochef.AutoChef.dto.RestaurantDto;

import br.com.autochef.AutoChef.model.Restaurant;
import br.com.autochef.AutoChef.model.User;
import org.springframework.http.ResponseEntity;

public record RegisterRestaurantDto(String name, String cnpj, String imageUrl, Float longitude,
                                    Float latitude, String email, String password) {

    public RegisterRestaurantDto(Restaurant restaurant){

        this(restaurant.getName(), restaurant.getCnpj(), restaurant.getImageUrl(), restaurant.getLongitude(),
                restaurant.getLatitude(), restaurant.getEmail(), restaurant.getPassword());
    }
}
