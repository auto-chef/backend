package br.com.autochef.AutoChef.dto.user;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record RegisterUserDTO(
        @NotBlank @Size(max=255)
        String name,
        @NotBlank @Size(min=11,max=11)
        String cpf,
        @NotBlank @Size(max=255) @Email
        String email,
        @NotBlank @Size(max=255)
        String password,
        @Past @NotNull
        LocalDate birthDate) {
}
