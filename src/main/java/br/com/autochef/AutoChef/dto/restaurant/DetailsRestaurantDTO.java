package br.com.autochef.AutoChef.dto.restaurant;

import br.com.autochef.AutoChef.dto.product.DetailsProductDTO;
import br.com.autochef.AutoChef.model.RestaurantModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public record DetailsRestaurantDTO(Long id, String name, String imageUrl, BigDecimal longitude, BigDecimal latitude, List<DetailsProductDTO> products) {

    public DetailsRestaurantDTO(RestaurantModel restaurant){
        this(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getImageUrl(),
                restaurant.getLatitude(),
                restaurant.getLongitude(),
                restaurant.getProducts().stream()
                        .map(DetailsProductDTO::new)
                        .collect(Collectors.toList())
        );
    }
}
