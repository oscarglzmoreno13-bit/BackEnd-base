package com.mx.forty.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.forty.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	@Query("SELECT p  FROM Producto p WHERE p.estatus.idEstatus = 1")
	public List<Producto> findAllActives();
	
	@Query("SELECT distinct p.upc  FROM Producto p WHERE p.estatus.idEstatus = 1 order by 1")
	public List<String> findAllUpc();
	
	@Query("SELECT p  FROM Producto p WHERE p.estatus.idEstatus = 1 and p.upc =:upc and p.sku = :sku")
	public List<Producto> findByUpcSku(@Param("upc") String upc, @Param("sku") String sku);
	
	@Query("SELECT p  FROM Producto p WHERE p.idProducto= :idProducto")
	public Optional<Producto> findById(@Param("idProducto") Integer idProducto);
	
	@Query("SELECT p  FROM Producto p WHERE p.marca.idMarca = :idMarca and p.estatus.idEstatus = 1")
	public List<Producto> findByMarca(@Param("idMarca") Integer idMarca);
}
