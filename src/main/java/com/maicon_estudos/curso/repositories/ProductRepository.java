package com.maicon_estudos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maicon_estudos.curso.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{


}
