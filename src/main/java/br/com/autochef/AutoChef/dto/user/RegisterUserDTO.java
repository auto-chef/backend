package br.com.autochef.AutoChef.dto.user;

import java.time.LocalDate;

public record RegisterUserDTO(String name, String cpf, String email, String password, LocalDate birthDate) {
}
