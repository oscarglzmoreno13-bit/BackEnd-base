package com.mx.forty.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.forty.entity.DetalleConfiguracionVenta;

public interface DetalleComfiguracionVentaRepository extends JpaRepository<DetalleConfiguracionVenta, Integer> {

	@Transactional
	@Modifying
	@Query("DELETE FROM DetalleConfiguracionVenta d WHERE d.configuracion.idConfiguracionVenta = :idConfiguracion")
	void deleteAllDetails(@Param("idConfiguracion") Integer idConfiguracion);
	
	
	@Query("SELECT DISTINCT c.configuracion.idConfiguracionVenta FROM DetalleConfiguracionVenta c where c.producto.idProducto = :idProducto ")
	public List<Integer> findCfgByProducto(@Param("idProducto") Integer idProducto);

}
