package br.com.autochef.AutoChef.dto.UserDto;

import br.com.autochef.AutoChef.model.User;

import java.time.LocalDate;

public record DetailsUserDto(String name, String cpf, String email, LocalDate birthDate) {

    public DetailsUserDto(User user){

        this(user.getName(), user.getCpf(), user.getEmail(), user.getBirthDate());
    }
}
