package br.com.autochef.AutoChef.controller;

import br.com.autochef.AutoChef.dto.user.DetailsUserDto;
import br.com.autochef.AutoChef.dto.user.RegisterUserDto;
import br.com.autochef.AutoChef.dto.user.UpdateUserDto;
import br.com.autochef.AutoChef.model.UserModel;
import br.com.autochef.AutoChef.repository.UserRepository;
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
@RequestMapping("users")//localhost:8080/useres
public class UsuarioController {

    @Autowired
    private UserRepository userRepository;

    //Method for registering a new user
    @PostMapping
    @Transactional
    public ResponseEntity<RegisterUserDto> post(@RequestBody RegisterUserDto registerUserDto,
                                                UriComponentsBuilder uriBuilder) {
        var user = new UserModel(registerUserDto);
        userRepository.save(user);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new RegisterUserDto(user));
    }

    //Method for updating a user's registration
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<UpdateUserDto> put(@PathVariable("id")Long id,
                                             @RequestBody UpdateUserDto udp){
        var user = userRepository.getReferenceById(id);
        user.update(udp);
        return ResponseEntity.ok(new UpdateUserDto(user));
    }

    //Method to delete a user's registration
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //
    //Method to search for a user by ID
    @GetMapping("{id}")
    public ResponseEntity<DetailsUserDto> getby(@PathVariable("id") Long id){
        var user = userRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetailsUserDto(user));
    }

    //Method to search all users
    @GetMapping
    public ResponseEntity<List<RegisterUserDto>> get(Pageable pageable){
        Pageable pg = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by("id").ascending());
        var listaUserDto = userRepository.findAll(pg).stream().
                map(RegisterUserDto::new).toList();
        return ResponseEntity.ok(listaUserDto);
    }

}
