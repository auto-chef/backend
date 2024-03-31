package br.com.autochef.AutoChef.controller;

import br.com.autochef.AutoChef.dto.RestaurantDto.DetailsRestDto;
import br.com.autochef.AutoChef.dto.RestaurantDto.RegisterRestaurantDto;
import br.com.autochef.AutoChef.dto.RestaurantDto.UpdateRestaurantDto;
import br.com.autochef.AutoChef.dto.UserDto.DetailsUserDto;
import br.com.autochef.AutoChef.dto.UserDto.RegisterUserDto;
import br.com.autochef.AutoChef.model.Restaurant;
import br.com.autochef.AutoChef.repository.RepositoryRestaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("restaurants")//localhost:8080/restaurants
public class RestaurantController {

    @Autowired
    private RepositoryRestaurant repositoryRestaurant;


    @PostMapping
    @Transactional
    public ResponseEntity<RegisterRestaurantDto> post(@RequestBody RegisterRestaurantDto registerRestaurantDto,
                                                      UriComponentsBuilder uriBuilder){
        var restaurant = new Restaurant(registerRestaurantDto);
        repositoryRestaurant.save(restaurant);
        var uri = uriBuilder.path("/restaurants/{id}").buildAndExpand(restaurant.getId()).toUri();
        return  ResponseEntity.created(uri).body(new RegisterRestaurantDto(restaurant));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<UpdateRestaurantDto> put(@PathVariable("id")Long id,
                                                   @RequestBody UpdateRestaurantDto udp){
        var rest = repositoryRestaurant.getReferenceById(id);
        rest.update(udp);
        return ResponseEntity.ok(new UpdateRestaurantDto((rest)));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        repositoryRestaurant.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<DetailsRestDto> getby(@PathVariable("id") Long id){
        var restaurant = repositoryRestaurant.getReferenceById(id);
        return ResponseEntity.ok(new DetailsRestDto(restaurant));
    }

    @GetMapping
    public ResponseEntity<List<DetailsRestDto>> get(Pageable pageable){
        Pageable pg = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by("id").ascending());
        var listaRestDto = repositoryRestaurant.findAll(pg).stream().
                map(DetailsRestDto::new).toList();
        return ResponseEntity.ok(listaRestDto);
    }
}
