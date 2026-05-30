package com.mx.forty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.forty.entity.ConfiguracionVenta;

public interface ConfiguracionVentaRepository extends JpaRepository<ConfiguracionVenta, Integer> {
	
	@Query("SELECT p  FROM ConfiguracionVenta p WHERE p.estatus.idEstatus = 1")
	public List<ConfiguracionVenta> findAllActives();
	
	@Query("SELECT p  FROM ConfiguracionVenta p WHERE p.campania.idCampania = :idCampania")
	public List<ConfiguracionVenta> findAllActivesByCampania(@Param("idCampania") Integer idCampania);
}
