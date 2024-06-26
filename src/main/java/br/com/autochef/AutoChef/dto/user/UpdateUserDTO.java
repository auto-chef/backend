package br.com.autochef.AutoChef.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateUserDTO(

        @NotBlank @Size(max=255)
        String name,
        @NotBlank @Size(max=255) @Email
        String email,
        @NotBlank @Size(max=255)
        String password) {
}
