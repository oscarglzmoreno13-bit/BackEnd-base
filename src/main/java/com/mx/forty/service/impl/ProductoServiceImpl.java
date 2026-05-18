package com.mx.forty.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mx.forty.dto.vo.ProductoVo;
import com.mx.forty.entity.Estatus;
import com.mx.forty.entity.Marca;
import com.mx.forty.entity.Producto;
import com.mx.forty.repository.ProductoRepository;
import com.mx.forty.service.ProductoService;
import com.mx.forty.util.Constantes;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public List<ProductoVo> findAll() {
		List<Producto> lista =  repository.findAllActives();
		List<ProductoVo> listaVo = new ArrayList<ProductoVo>();
		for (Producto producto : lista) {
			listaVo.add(getEntityToVo(producto));
		}
		return listaVo;
	}

	
	private ProductoVo getEntityToVo(Producto producto) {
		ProductoVo vo = new  ProductoVo();
		vo.setIdProducto(producto.getIdProducto());
		vo.setUpc(producto.getUpc());
		vo.setSku(producto.getSku());
		vo.setNombre(producto.getNombre());
		vo.setDescripcion(producto.getDescripcion());
		vo.setMonto(producto.getMonto());
		vo.setPrecioVenta(producto.getPrecioVenta());
		vo.setIdMArca(producto.getMarca().getIdMarca());
		vo.setNombreMarca(producto.getMarca().getNombre());
		vo.setIdEstatus(producto.getEstatus().getIdEstatus());
		vo.setNombreEstatus(producto.getEstatus().getNombre());
		vo.setUpcExistente(true);
		vo.setClave(producto.getClave());
		return vo;
	}
	
	private Producto getVoToEntity(ProductoVo vo) {
		Producto producto = new Producto();
		producto.setIdProducto(vo.getIdProducto());
		producto.setUpc(vo.getUpc());
		producto.setSku(vo.getSku());
		producto.setDescripcion(vo.getDescripcion());
		producto.setNombre(vo.getNombre());
		producto.setMonto(vo.getMonto());
		producto.setMarca(new Marca());
		producto.getMarca().setIdMarca(vo.getIdMArca());
		producto.setEstatus(new Estatus());
		producto.getEstatus().setIdEstatus(Constantes.ESTATUS_GRAL_ACTIVO);
		producto.setPrecioVenta(vo.getPrecioVenta());
		producto.setClave(vo.getClave());
		return producto;
	}
	
	public void save(ProductoVo vo) {
		Producto producto = getVoToEntity(vo);
		List<Producto> lista = repository.findByUpcSku(vo.getUpc(), vo.getSku());
		if(producto.getIdProducto()==null) {
			if(lista!=null && !lista.isEmpty()) {
				 throw new IllegalArgumentException("Los datos de UPC y SKU ya estan asociados a otro Producto");
			} else {
				repository.save(producto);
			}
		} else {
			for (Producto prod : lista) {
				if(!prod.getIdProducto().equals(producto.getIdProducto())) {
					throw new IllegalArgumentException("Los datos de UPC y SKU ya estan asociados a otro Producto");
				}
			}
			repository.save(producto);
		}
		
	}

	@Override
	public List<String> findAllUpc() {
		// TODO Auto-generated method stub
		return repository.findAllUpc();
	}
	
	@Override
	public void deleteProducto(Integer idProducto) {
	    try {
	        Optional<Producto> prod = repository.findById(idProducto);
	        if(prod.isPresent()) {
	        	Producto p = prod.get();
	        	p.getEstatus().setIdEstatus(Constantes.ESTATUS_GRAL_INACTIVO);
	        	repository.save(p);
	        }
	    } catch (EmptyResultDataAccessException e) {
	        throw new IllegalArgumentException("El producto con id " + idProducto + " no existe");
	    } catch (Exception e) {
	        throw new RuntimeException("Error al eliminar el producto: " + e.getMessage());
	    }
	}
	

}
