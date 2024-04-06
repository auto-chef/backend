package br.com.autochef.AutoChef.dto.user;

import br.com.autochef.AutoChef.model.UserModel;

public record UpdateUserDTO(String name, String email, String password) {

    public UpdateUserDTO(UserModel user){
        this(user.getName(), user.getEmail(), user.getPassword());
    }

}
