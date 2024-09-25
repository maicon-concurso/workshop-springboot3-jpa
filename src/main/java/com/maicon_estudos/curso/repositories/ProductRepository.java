package com.maicon_estudos.curso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maicon_estudos.curso.entities.Category;
import com.maicon_estudos.curso.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{


}
