package com.mx.forty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.forty.entity.Municipio;

public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

	@Query("Select m FROM Municipio m WHERE m.estado.idEstado = :idEstado")
	public List<Municipio> findByIdEstado(@Param("idEstado") Integer idEstado);
}
