package br.com.autochef.AutoChef.model;

import br.com.autochef.AutoChef.dto.RegisterUserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name="Tb_User")
public class User {


    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private LocalDate registrationDate;
    private LocalDate birthDate;

    public User(RegisterUserDto registerUserDto){
        name = registerUserDto.name();
        cpf = registerUserDto.cpf();
        email = registerUserDto.email();
        password = registerUserDto.password();
        registrationDate = registerUserDto.registrationDate();
        birthDate = registerUserDto.birthDate();
    }
}
