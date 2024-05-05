package br.com.autochef.AutoChef.dto.restaurant;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

public record RegisterRestaurantDTO(
        @NotBlank @Size(max=255)
        String name,
        @NotBlank @Size(min=14, max=14)
        String cnpj,
        @NotBlank @Size(max=255) @URL
        String imageUrl,
        @NotNull
        BigDecimal longitude,
        @NotNull
        BigDecimal latitude,
        @NotBlank @Size(max=255) @Email
        String email,
        @NotBlank @Size(max=255)
        String password) {
}
