package com.mx.forty.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.forty.entity.TipoEstatus;

public interface TipoEstatusRepository extends JpaRepository<TipoEstatus, Integer> {

	public List<TipoEstatus> findAll();
	
	public TipoEstatus findByClave(String clave);
	
}
