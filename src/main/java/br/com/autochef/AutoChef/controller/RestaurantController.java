package br.com.autochef.AutoChef.controller;

import br.com.autochef.AutoChef.dto.restaurant.DetailsRestaurantDto;
import br.com.autochef.AutoChef.dto.restaurant.RegisterRestaurantDto;
import br.com.autochef.AutoChef.dto.restaurant.UpdateRestaurantDto;
import br.com.autochef.AutoChef.model.RestaurantModel;
import br.com.autochef.AutoChef.repository.RestaurantRepository;
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
    private RestaurantRepository restaurantRepository;

    //Method that will insert a new restaurant
    @PostMapping
    @Transactional
    public ResponseEntity<RegisterRestaurantDto> post(@RequestBody RegisterRestaurantDto registerRestaurantDto,
                                                      UriComponentsBuilder uriBuilder){
        var restaurant = new RestaurantModel(registerRestaurantDto);
        restaurantRepository.save(restaurant);
        var uri = uriBuilder.path("/restaurants/{id}").buildAndExpand(restaurant.getId()).toUri();
        return  ResponseEntity.created(uri).body(new RegisterRestaurantDto(restaurant));
    }

    //Method that will update a restaurant's registration
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<UpdateRestaurantDto> put(@PathVariable("id")Long id,
                                                   @RequestBody UpdateRestaurantDto udp){
        var rest = restaurantRepository.getReferenceById(id);
        rest.update(udp);
        return ResponseEntity.ok(new UpdateRestaurantDto((rest)));
    }

    //Method that will delete a restaurant's registration
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        restaurantRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //Method that will search by restaurant ID
    @GetMapping("{id}")
    public ResponseEntity<DetailsRestaurantDto> getby(@PathVariable("id") Long id){
        var restaurant = restaurantRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetailsRestaurantDto(restaurant));
    }

    //Method that searches all registered restaurants
    @GetMapping
    public ResponseEntity<List<DetailsRestaurantDto>> get(Pageable pageable){
        Pageable pg = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by("id").ascending());
        var listaRestDto = restaurantRepository.findAll(pg).stream().
                map(DetailsRestaurantDto::new).toList();
        return ResponseEntity.ok(listaRestDto);
    }
}
