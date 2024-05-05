package br.com.autochef.AutoChef.dto.restaurant;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record UpdateRestaurantDTO(
        @Size(max=255)
        String name,
        @Size(max=255) @Email
        String email,
        @Size(max=255)
        String password,
        @Size(max=255)
        String imageUrl,
        @NotNull
        BigDecimal longitude,
        @NotNull
        BigDecimal latitude) {
}
