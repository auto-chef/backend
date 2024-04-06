package br.com.autochef.AutoChef.dto.restaurant;

import java.math.BigDecimal;

public record RegisterRestaurantDTO(String name, String cnpj, String imageUrl, BigDecimal longitude, BigDecimal latitude, String email, String password) {
}
