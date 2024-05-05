package br.com.autochef.AutoChef.dto.restaurant;

import br.com.autochef.AutoChef.dto.product.DetailsProductDTO;
import br.com.autochef.AutoChef.model.RestaurantModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public record DetailsRestaurantDTO(Long id, String name, String imageUrl, String cnpj, BigDecimal longitude, BigDecimal latitude) {

    public DetailsRestaurantDTO(RestaurantModel restaurant){
        this(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getImageUrl(),
                restaurant.getCnpj(),
                restaurant.getLatitude(),
                restaurant.getLongitude()
        );
    }
}
