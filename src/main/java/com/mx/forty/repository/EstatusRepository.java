package com.mx.forty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.forty.entity.Estatus;

public interface EstatusRepository extends JpaRepository<Estatus, Integer> {

	public Estatus findByClave(String clave);
}
