package br.com.autochef.AutoChef.dto.user;

import br.com.autochef.AutoChef.model.UserModel;

import java.time.LocalDate;

public record DetailsUserDto(String name, String cpf, String email, LocalDate birthDate) {

    public DetailsUserDto(UserModel user){

        this(user.getName(), user.getCpf(), user.getEmail(), user.getBirthDate());
    }
}
