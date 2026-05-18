package com.mx.forty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.forty.entity.Campania;

public interface CampaniaRepository extends JpaRepository<Campania, Integer> {

	@Query("SELECT m  FROM Campania m WHERE m.estatus.idEstatus = 1")
	public List<Campania> findAllActives();
	
	@Query("SELECT m  FROM Campania m WHERE (m.nombre = :nombre) AND m.estatus.idEstatus = 1")
	public List<Campania> validaCampaniaExistente(@Param("nombre") String nombre);
}
