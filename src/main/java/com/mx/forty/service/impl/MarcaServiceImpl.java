package com.mx.forty.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.forty.entity.Marca;
import com.mx.forty.repository.MarcaRepository;
import com.mx.forty.service.MarcaService;

@Service
public class MarcaServiceImpl implements MarcaService {

	 @Autowired
	    private MarcaRepository repository;

	    @Override
	    public List<Marca> findAll() {
	        return repository.findAll();
	    }

	    @Override
	    public void save(Marca marca) {
	        repository.save(marca);
	    }
}
