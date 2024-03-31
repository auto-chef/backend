package br.com.autochef.AutoChef.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Entity

@Table(name="TB_RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String cnpj;
    private String imageUrl;
    private Float longitude;
    private Float latidude;
    private String email;
    private String password;



}
