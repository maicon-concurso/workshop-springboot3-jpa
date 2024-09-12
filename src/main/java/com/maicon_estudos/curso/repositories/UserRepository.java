package com.maicon_estudos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maicon_estudos.curso.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
