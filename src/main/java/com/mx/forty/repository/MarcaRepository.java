package com.mx.forty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.forty.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
	
	@Query("SELECT p  FROM Marca p WHERE p.estatus.idEstatus = 1 order by 1")
	public List<Marca> findAllActives();

}
