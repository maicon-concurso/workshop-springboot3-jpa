package com.maicon_estudos.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maicon_estudos.curso.entities.Category;
import com.maicon_estudos.curso.services.CategoryService;

@RestController  // Indica que esta classe é um controlador REST, responsável por tratar requisições HTTP.
@RequestMapping(value="/categories/")  // Define a URL base que serhttps://desktop.postman.com/?desktopVersion=11.11.0&userId=38133108&teamId=0&region=usá usada para acessar os endpoints deste controlador. Neste caso, /users.
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
    @GetMapping  // Mapeia requisições GET (quando o cliente pede dados) para o método abaixo.
    public ResponseEntity<List<Category>> findAll() {
    	
    	List<Category> list = service.findAll();

        // Retorna uma resposta HTTP 200 (OK) com o objeto Category no corpo da resposta.
        // ResponseEntity é uma classe do Spring usada para personalizar a resposta HTTP.
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
    	Category obj = service.findById(id);
    	return ResponseEntity.ok().body(obj);
    }
    
}
