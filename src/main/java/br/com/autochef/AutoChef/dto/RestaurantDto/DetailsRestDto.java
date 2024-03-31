package br.com.autochef.AutoChef.dto.RestaurantDto;

import br.com.autochef.AutoChef.model.Restaurant;
import org.springframework.http.ResponseEntity;

public record DetailsRestDto(String name, String imageUrl, Float longitude, Float latitude) {

    public DetailsRestDto(Restaurant rest){
        this(rest.getName(), rest.getImageUrl(), rest.getLatitude(), rest.getLongitude());
    }
}
