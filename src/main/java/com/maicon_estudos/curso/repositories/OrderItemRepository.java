package com.maicon_estudos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maicon_estudos.curso.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
