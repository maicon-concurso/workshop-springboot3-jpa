package com.maicon_estudos.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.maicon_estudos.curso.entities.User;
import com.maicon_estudos.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria", "maria@gmail.com", "69993337575", "00394418552");
		User u2 = new User(null, "João", "joao@gmail.com", "6993337577", "0039445252");

		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
