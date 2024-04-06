package br.com.autochef.AutoChef.dto.restaurant;

import java.math.BigDecimal;

public record UpdateRestaurantDTO(String name, String email, String password, String imageUrl, BigDecimal longitude, BigDecimal latitude) {
}
