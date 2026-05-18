package com.mx.forty.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.forty.entity.TipoEstatus;
import com.mx.forty.repository.TipoEstatusRepository;
import com.mx.forty.service.TipoEstatusService;


@Service
public class TipoEstatusServiceImpl implements TipoEstatusService {

	@Autowired
	private TipoEstatusRepository repository;

	@Override
	public List<TipoEstatus> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public TipoEstatus findByClave(String clave) {
		// TODO Auto-generated method stub
		return repository.findByClave(clave);
	}
}
