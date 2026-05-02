package com.mx.forty;

import org.springframework.beans.factory.annotation.Autowired;

import com.mx.forty.service.TipoEstatusService;

public class Prueba {

	public TestService test;
	public static TipoEstatusService tipoEstatus;
	
	public static void find() {
		
		tipoEstatus.finAll();
	}
	
	
	
	
	public static void main(String[] args) {
		
		Prueba p = new Prueba(null, null);
		p.find();
	}

	@Autowired
	public Prueba(TestService test, TipoEstatusService tipoEstatus) {
		this.test = test;
		this.tipoEstatus = tipoEstatus;
	}
}
