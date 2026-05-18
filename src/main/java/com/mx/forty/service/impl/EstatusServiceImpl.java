package com.mx.forty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mx.forty.entity.Estatus;
import com.mx.forty.repository.EstatusRepository;
import com.mx.forty.service.EstatusService;

public class EstatusServiceImpl implements EstatusService {

	@Autowired
	EstatusRepository repository;
	
	@Override
	public Estatus findByClave(String clave) {
		// TODO Auto-generated method stub
		return repository.findByClave(clave);
	}

}
