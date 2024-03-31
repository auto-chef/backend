package br.com.autochef.AutoChef.controller;

import br.com.autochef.AutoChef.dto.RegisterUserDto;
import br.com.autochef.AutoChef.model.User;
import br.com.autochef.AutoChef.repository.UserRepository;
import com.fasterxml.jackson.core.TreeNode;
import jdk.javadoc.doclet.Reporter;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("users")//localhost:8080/useres
public class UsuarioController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<RegisterUserDto> post(@RequestBody RegisterUserDto registerUserDto, UriComponentsBuilder uriBuilder) {
        //Instanciar um investimento com os dados do dto
        var user = new User(registerUserDto);
        userRepository.save(user); //cadastrar ou atualiza
        //Retornar o status code 201, o objeto criado e a url para acessar o recurso criado
        var uri = uriBuilder.path("/investimentos/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new RegisterUserDto(user));
    }

}
