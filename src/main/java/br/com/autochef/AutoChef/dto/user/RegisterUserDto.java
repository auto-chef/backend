package br.com.autochef.AutoChef.dto.user;

import br.com.autochef.AutoChef.model.UserModel;

import java.time.LocalDate;

public record RegisterUserDto( String name, String cpf, String email, String password,
                              LocalDate registrationDate, LocalDate birthDate) {
    public  RegisterUserDto(UserModel user){
        this(user.getName(), user.getCpf(), user.getEmail(), user.getPassword(),
                user.getRegistrationDate(),user.getBirthDate());
    }

}
