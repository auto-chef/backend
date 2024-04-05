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
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<RegisterUserDto> post(@RequestBody RegisterUserDto registerUserDto, UriComponentsBuilder uriBuilder) {
        var user = new UserModel(registerUserDto);
        userRepository.save(user);

        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new RegisterUserDto(user));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<UpdateUserDto> put(@PathVariable("id")Long id, @RequestBody UpdateUserDto udp){
        var user = userRepository.getReferenceById(id);
        user.update(udp);

        return ResponseEntity.ok(new UpdateUserDto(user));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        userRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<DetailsUserDto> getby(@PathVariable("id") Long id){
        var user = userRepository.getReferenceById(id);

        return ResponseEntity.ok(new DetailsUserDto(user));
    }

    @GetMapping
    public ResponseEntity<List<RegisterUserDto>> get(Pageable pageable){
        Pageable pg = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id").ascending());

        var userList = userRepository.findAll(pg).stream().map(RegisterUserDto::new).toList();
        return ResponseEntity.ok(userList);
    }
}
