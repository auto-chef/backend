package br.com.autochef.AutoChef.controller;

import br.com.autochef.AutoChef.dto.user.DetailsUserDTO;
import br.com.autochef.AutoChef.dto.user.RegisterUserDTO;
import br.com.autochef.AutoChef.dto.user.UpdateUserDTO;
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
@RequestMapping("users") // http://localhost:8080/users
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<RegisterUserDTO> createUser(@RequestBody RegisterUserDTO registerUserDto, UriComponentsBuilder uriBuilder) {
        var user = new UserModel(registerUserDto);
        userRepository.save(user);

        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new RegisterUserDTO(user));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<UpdateUserDTO> updateUser(@PathVariable("id")Long id, @RequestBody UpdateUserDTO udp){
        var user = userRepository.getReferenceById(id);
        user.update(udp);

        return ResponseEntity.ok(new UpdateUserDTO(user));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<DetailsUserDTO> getUserById(@PathVariable("id") Long id){
        var user = userRepository.getReferenceById(id);

        return ResponseEntity.ok(new DetailsUserDTO(user));
    }

    @GetMapping
    public ResponseEntity<List<RegisterUserDTO>> getUserList(Pageable pageable){
        Pageable pg = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id").ascending());
        var userList = userRepository.findAll(pg).stream().map(RegisterUserDTO::new).toList();

        return ResponseEntity.ok(userList);
    }
}
