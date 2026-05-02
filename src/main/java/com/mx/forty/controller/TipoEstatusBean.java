package com.mx.forty.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mx.forty.TipoEstatusRepository;
import com.mx.forty.entity.TipoEstatus;


@Component
@Scope("session")
public class TipoEstatusBean {

	@Autowired
	private TipoEstatusRepository tipoEstatusRepo;
	private List<TipoEstatus> listaTipoEstatus ;
	
	@PostConstruct
	public void init() {
		listaTipoEstatus = tipoEstatusRepo.findAll();
	}

	public List<TipoEstatus> getListaTipoEstatus() {
		return listaTipoEstatus;
	}

	public void setListaTipoEstatus(List<TipoEstatus> listaTipoEstatus) {
		this.listaTipoEstatus = listaTipoEstatus;
	}
}
