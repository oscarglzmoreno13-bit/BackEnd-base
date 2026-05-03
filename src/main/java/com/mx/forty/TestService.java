package com.mx.forty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.mx.forty.entity.TipoEstatus;
import com.mx.forty.service.TipoEstatusService;

public class TestService extends JpaConfig 	{
	

	@Autowired
	static TipoEstatusService tipoEstatus;
	
	@Autowired
	TipoEstatusRepository tipoEstatusRepository;
	
//	@Transactional(transactionManager = "transactionManager")	
	public void getTipoEstatus() {
		
	}

//	@Transactional(transactionManager = "transactionManager")
//	public List<TipoEstatus>  findAll() {
//		return tipoEstatus.finAll();
//		
//	}
}
