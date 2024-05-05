package br.com.autochef.AutoChef.dto.user;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record RegisterUserDTO(
        @Size(max=255)
        String name,
        @Size(min=11,max=11)
        String cpf,
        @Size(max=255)
        String email,
        @Size(max=255)
        String password,
        @Future @NotNull
        LocalDate birthDate) {
}
