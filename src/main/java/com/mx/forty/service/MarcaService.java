package com.mx.forty.service;

import java.util.List;

import com.mx.forty.entity.Marca;

public interface MarcaService {

	public List<Marca> findAll();
	public void save(Marca marca);
}
