package com.mx.forty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.forty.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	@Query("SELECT p FROM Persona p " +
		       "WHERE p.estatus.idEstatus = 1 " +
		       "AND p.tipoPersona.idTipoPersona = 2 " +
		       "AND p.nombre LIKE CONCAT('%', :nombre, '%')")
		List<Persona> findLikeNombre(@Param("nombre") String nombre);

	@Query("SELECT p FROM Persona p " +
		       "WHERE p.estatus.idEstatus = 1 " +
		       "AND p.tipoPersona.idTipoPersona = 1")
	List<Persona> buscaUsuarios();
}
