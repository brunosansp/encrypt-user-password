package br.com.brunosansp.encryptuserpassword.controllers;

import br.com.brunosansp.encryptuserpassword.models.UserModel;
import br.com.brunosansp.encryptuserpassword.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UserController {
    
    private final UserRepository userRepository;
    
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @GetMapping("/listar-todos")
    public ResponseEntity<List<UserModel>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }
    
    @PostMapping("/salvar")
    public ResponseEntity<UserModel> save(@RequestBody UserModel user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
    }
}
