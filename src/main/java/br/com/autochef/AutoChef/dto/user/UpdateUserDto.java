package br.com.autochef.AutoChef.dto.user;

import br.com.autochef.AutoChef.model.UserModel;

public record UpdateUserDto(String name, String email, String password) {

    public UpdateUserDto(UserModel user){
        this(user.getName(), user.getEmail(), user.getPassword());
    }

}
