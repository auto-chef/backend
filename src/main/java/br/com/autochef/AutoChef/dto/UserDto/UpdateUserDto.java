package br.com.autochef.AutoChef.dto.UserDto;

import br.com.autochef.AutoChef.model.User;

public record UpdateUserDto(String name, String email, String password) {

    public UpdateUserDto(User user){
        this(user.getName(), user.getEmail(), user.getPassword());
    }

}
