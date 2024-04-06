package br.com.autochef.AutoChef.dto.user;

import br.com.autochef.AutoChef.model.UserModel;

import java.time.LocalDate;

public record RegisterUserDTO(String name, String cpf, String email, String password, LocalDate birthDate) {
    public RegisterUserDTO(UserModel user){
        this(user.getName(), user.getCpf(), user.getEmail(), user.getPassword(), user.getBirthDate());
    }

}
