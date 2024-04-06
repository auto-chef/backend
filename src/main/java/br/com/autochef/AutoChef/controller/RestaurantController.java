package br.com.autochef.AutoChef.controller;

import br.com.autochef.AutoChef.dto.restaurant.DetailsRestaurantDTO;
import br.com.autochef.AutoChef.dto.restaurant.RegisterRestaurantDTO;
import br.com.autochef.AutoChef.dto.restaurant.UpdateRestaurantDTO;
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
    public ResponseEntity<RegisterRestaurantDTO> post(@RequestBody RegisterRestaurantDTO registerRestaurantDto,
                                                      UriComponentsBuilder uriBuilder){
        var restaurant = new RestaurantModel(registerRestaurantDto);
        restaurantRepository.save(restaurant);
        var uri = uriBuilder.path("/restaurants/{id}").buildAndExpand(restaurant.getId()).toUri();
        return  ResponseEntity.created(uri).body(new RegisterRestaurantDTO(restaurant));
    }

    //Method that will update a restaurant's registration
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<UpdateRestaurantDTO> put(@PathVariable("id")Long id,
                                                   @RequestBody UpdateRestaurantDTO udp){
        var rest = restaurantRepository.getReferenceById(id);
        rest.update(udp);
        return ResponseEntity.ok(new UpdateRestaurantDTO((rest)));
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
    public ResponseEntity<DetailsRestaurantDTO> getby(@PathVariable("id") Long id){
        var restaurant = restaurantRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetailsRestaurantDTO(restaurant));
    }

    //Method that searches all registered restaurants
    @GetMapping
    public ResponseEntity<List<DetailsRestaurantDTO>> get(Pageable pageable){
        Pageable pg = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by("id").ascending());
        var listaRestDto = restaurantRepository.findAll(pg).stream().
                map(DetailsRestaurantDTO::new).toList();
        return ResponseEntity.ok(listaRestDto);
    }
}
