package com.maicon_estudos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maicon_estudos.curso.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{

}
