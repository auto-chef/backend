package br.com.autochef.AutoChef.model;


import br.com.autochef.AutoChef.dto.restaurant.RegisterRestaurantDto;
import br.com.autochef.AutoChef.dto.restaurant.UpdateRestaurantDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Entity

@Table(name="TB_RESTAURANT")
public class RestaurantModel {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String cnpj;
    private String imageUrl;
    private Float longitude;
    private Float latitude;
    private String email;
    private String password;

    public RestaurantModel(RegisterRestaurantDto rest){

        name = rest.name();
        cnpj = rest.cnpj();
        imageUrl = rest.imageUrl();
        longitude = rest.longitude();
        latitude = rest.latitude();
        email = rest.email();
        password = rest.password();
    }

    public void update(UpdateRestaurantDto udp){
        name = udp.name();
        email = udp.email();
        password = udp.password();
        imageUrl = udp.imageUrl();
        longitude = udp.longitude();
        latitude = udp.latitude();
    }
}
