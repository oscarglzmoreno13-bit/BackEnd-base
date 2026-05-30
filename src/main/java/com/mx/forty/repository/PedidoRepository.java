package com.mx.forty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.forty.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
