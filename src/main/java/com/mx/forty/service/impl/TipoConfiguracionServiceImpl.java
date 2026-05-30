package com.mx.forty.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.forty.dto.vo.TipoConfiguracionVo;
import com.mx.forty.entity.TipoConfiguracion;
import com.mx.forty.repository.TipoConfiguracionRepository;
import com.mx.forty.service.TipoConfiguracionService;

@Service
public class TipoConfiguracionServiceImpl implements TipoConfiguracionService {

	 @Autowired
	TipoConfiguracionRepository repository;
	
	@Override
	public List<TipoConfiguracionVo> findAll() {
		// TODO Auto-generated method stub
		List<TipoConfiguracion> lista = repository.findAll();
		List<TipoConfiguracionVo> lst = new ArrayList<TipoConfiguracionVo>();
		for (TipoConfiguracion tipoConfiguracion : lista) {
			TipoConfiguracionVo vo = new TipoConfiguracionVo();
			vo.setClave(tipoConfiguracion.getClave());
			vo.setIdTipoConfiguracion(tipoConfiguracion.getIdTipoConfiguracion());
			vo.setNombre(tipoConfiguracion.getNombre());
			lst.add(vo);
		}
		return lst;
	}

}
