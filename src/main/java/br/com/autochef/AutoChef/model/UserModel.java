package br.com.autochef.AutoChef.model;

import br.com.autochef.AutoChef.dto.user.RegisterUserDto;
import br.com.autochef.AutoChef.dto.user.UpdateUserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name="TB_USER")
public class UserModel {

    @Id
    @GeneratedValue
    @Column(name="ID_USER")
    private Long id;

    @Column(name="NM_USER", nullable = false, length = 255)
    private String name;

    @Column(name="NR_CPF", nullable = false, length = 11)
    private String cpf;

    @Column(name="DS_EMAIL", nullable = false, length = 255)
    private String email;

    @Column(name="NM_PASSWORD", nullable = false, length = 255)
    private String password;

    @Column(name="DT_REGISTRATION", nullable = false)
    private LocalDate registrationDate;

    @Column(name="DT_BIRTHDATE", nullable = false)
    private LocalDate birthDate;

    public UserModel(RegisterUserDto registerUserDto){
        name = registerUserDto.name();
        cpf = registerUserDto.cpf();
        email = registerUserDto.email();
        password = registerUserDto.password();
        registrationDate = registerUserDto.registrationDate();
        birthDate = registerUserDto.birthDate();
    }

    public void update(UpdateUserDto updateuserDto){
        name = updateuserDto.name();
        email = updateuserDto.email();
        password = updateuserDto.password();
    }

}
