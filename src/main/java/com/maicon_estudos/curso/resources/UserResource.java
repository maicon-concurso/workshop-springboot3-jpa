package com.maicon_estudos.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maicon_estudos.curso.entities.User;

@RestController  // Indica que esta classe é um controlador REST, responsável por tratar requisições HTTP.
@RequestMapping(value="/users")  // Define a URL base que será usada para acessar os endpoints deste controlador. Neste caso, /users.
public class UserResource {

    @GetMapping  // Mapeia requisições GET (quando o cliente pede dados) para o método abaixo.
    public ResponseEntity<User> findAll() {
    	
         Cria um objeto User com dados fictícios.
         User u = new User(1L, "Maria", "maria@gmail", "999999", "123456789");

        // Retorna uma resposta HTTP 200 (OK) com o objeto User no corpo da resposta.
        // ResponseEntity é uma classe do Spring usada para personalizar a resposta HTTP.
        return ResponseEntity.ok(u);
    }
}
