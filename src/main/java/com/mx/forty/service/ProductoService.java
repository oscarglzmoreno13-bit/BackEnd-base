package com.mx.forty.service;

import java.util.List;

import com.mx.forty.dto.vo.ProductoVo;

public interface ProductoService {

	
	public List<ProductoVo> findAll();
	
	public List<String> findAllUpc();
	
	public void save(ProductoVo vo);
	
	public void deleteProducto(Integer idProducto);

}
