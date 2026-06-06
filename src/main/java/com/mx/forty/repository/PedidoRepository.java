package com.mx.forty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.forty.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	@Query("SELECT p  FROM Pedido p WHERE p.estatus.idEstatus = 3 order by 1")
	public List<Pedido> findPedidosPendientes();
}
