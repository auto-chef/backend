package br.com.autochef.AutoChef.dto.restaurant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record RegisterRestaurantDTO(
        @NotBlank @Size(max=255)
        String name,
        @NotBlank @Size(min=14, max=14)
        String cnpj,
        @NotBlank @Size(max=255)
        String imageUrl,
        @NotBlank
        BigDecimal longitude,
        @NotBlank
        BigDecimal latitude,
        @NotBlank @Size(max=255)
        String email,
        @NotBlank @Size(max=255)
        String password) {
}
