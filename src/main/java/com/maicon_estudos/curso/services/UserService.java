package com.maicon_estudos.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maicon_estudos.curso.entities.User;
import com.maicon_estudos.curso.repositories.UserRepository;
import com.maicon_estudos.curso.services.exceptions.ResouceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
		
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResouceNotFoundException(id));
	}
	public User insert(User obj){
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);;
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
