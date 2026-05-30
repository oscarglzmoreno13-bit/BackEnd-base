package com.mx.forty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.forty.entity.Colonia;

public interface ColoniaRepository extends JpaRepository<Colonia, Integer> {

	@Query("Select m FROM Colonia m WHERE m.municipio.idMunicipio = :idMcpio")
	public List<Colonia> findByIdMcpio(@Param("idMcpio") Integer idMcpio);
	
	@Query("SELECT DISTINCT c.codigoPostal FROM Colonia c")
	List<String> findDistinctCodigosPostales();
	
	@Query("Select m FROM Colonia m WHERE m.codigoPostal = :codigoPostal")
	public List<Colonia> findColoniasByCp(@Param("codigoPostal") String codigoPostal);

}
