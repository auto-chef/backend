package br.com.autochef.AutoChef.model;

import br.com.autochef.AutoChef.dto.user.RegisterUserDTO;
import br.com.autochef.AutoChef.dto.user.UpdateUserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name="TB_USER")
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @Column(name="DT_REGISTRATION", nullable = false, updatable = false)
    private LocalDateTime registrationDate;

    @Column(name="DT_BIRTHDATE", nullable = false)
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<OrderModel> orders;

    public UserModel(RegisterUserDTO registerUserDto){
        this.name = registerUserDto.name();
        this.cpf = registerUserDto.cpf();
        this.email = registerUserDto.email();
        this.password = registerUserDto.password();
        this.birthDate = registerUserDto.birthDate();
    }

    public void update(UpdateUserDTO updateuserDto){
        if(updateuserDto.name() != null) this.name = updateuserDto.name();
        if(updateuserDto.email() != null) this.email = updateuserDto.email();
        if(updateuserDto.password() != null) this.password = updateuserDto.password();
    }

}
