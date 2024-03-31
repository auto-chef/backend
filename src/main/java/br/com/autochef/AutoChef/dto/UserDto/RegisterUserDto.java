package br.com.autochef.AutoChef.dto.UserDto;

import br.com.autochef.AutoChef.model.User;

import java.time.LocalDate;

public record RegisterUserDto( String name, String cpf, String email, String password,
                              LocalDate registrationDate, LocalDate birthDate) {
    public  RegisterUserDto(User user){
        this(user.getName(), user.getCpf(), user.getEmail(), user.getPassword(),
                user.getRegistrationDate(),user.getBirthDate());
    }

}
