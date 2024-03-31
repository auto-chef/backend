package br.com.autochef.AutoChef.dto.userDto;

import br.com.autochef.AutoChef.model.User;

public record UpdateuserDto(String name, String email, String password) {

    public UpdateuserDto(User user){
        this(user.getName(), user.getEmail(), user.getPassword());
    }

}
