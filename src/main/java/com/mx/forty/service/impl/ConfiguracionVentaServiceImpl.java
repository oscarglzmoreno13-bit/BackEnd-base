package com.mx.forty.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.forty.entity.ConfiguracionVenta;
import com.mx.forty.entity.DetalleConfiguracionVenta;
import com.mx.forty.entity.Estatus;
import com.mx.forty.repository.ConfiguracionVentaRepository;
import com.mx.forty.repository.DetalleComfiguracionVentaRepository;
import com.mx.forty.service.ConfiguracionVentaService;
import com.mx.forty.util.Constantes;
import com.mx.forty.util.Utilerias;

@Service
public class ConfiguracionVentaServiceImpl implements ConfiguracionVentaService {

	@Autowired
	ConfiguracionVentaRepository repository;
	
	@Autowired
	DetalleComfiguracionVentaRepository repositoryDetalle;

	@Override
	public List<Map<String, Object>> finAll() {
		List<ConfiguracionVenta> listaConfiguracion = repository.findAllActives();
		List<Map<String, Object>>lista = new ArrayList<Map<String,Object>>();
		for (ConfiguracionVenta configuracionVenta : listaConfiguracion) {
			lista.add(Utilerias.mapconvertEntityConfiguracionVtaToJson(configuracionVenta));
		}
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public void save(Map<String, Object> json) {
		// TODO Auto-generated method stub
		    ConfiguracionVenta configuracion = Utilerias.convertJstonToEntityConfiguracionVta(json);
		    configuracion.setEstatus(new Estatus());
		    configuracion.getEstatus().setIdEstatus(Constantes.ESTATUS_GRAL_ACTIVO);

		    // Asegurar que cada detalle apunte al maestro
		    if (configuracion.getDetallesConfiguracion() != null) {
		        for (DetalleConfiguracionVenta detalle : configuracion.getDetallesConfiguracion()) {
		            detalle.setConfiguracion(configuracion);
		        }
		    }
		    if(configuracion.getIdConfiguraciónVenta()!=null) {
		    	repositoryDetalle.deleteAllDetails(configuracion.getIdConfiguraciónVenta());
		    }
		    // Guardar maestro y detalles en cascada
		    repository.save(configuracion);
	}

	@Override
	public void delete(Map<String, Object> json) {
		// TODO Auto-generated method stub
		Integer idConfiguracion = (Integer) json.get("idConfiguracion");
		ConfiguracionVenta configuracion = repository.findById(idConfiguracion).get();
		configuracion.getEstatus().setIdEstatus(Constantes.ESTATUS_GRAL_INACTIVO);
		repository.save(configuracion);
	}

	@Override
	public List<Map<String, Object>> findConfiguracionesByCampania(Integer idCampania) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy, HH:mm");
		String hoyStr = sdf.format(new Date());
        String fechaStr = null;
        Date hoy = sdf.parse(hoyStr, new java.text.ParsePosition(0));
        Date fechaNormalizada = null;
        
        
		List<ConfiguracionVenta> listaConfiguracion = null;
		if(idCampania==null || (idCampania!=null && idCampania==0)) {
			listaConfiguracion = repository.findAllActives();
		} else {
			listaConfiguracion = repository.findAllActivesByCampania(idCampania);
		}
		
		List<Map<String, Object>>lista = new ArrayList<Map<String,Object>>();
		for (ConfiguracionVenta configuracionVenta : listaConfiguracion) {
			fechaStr = sdf.format(configuracionVenta.getFechaFin());
			fechaNormalizada = sdf.parse(fechaStr, new java.text.ParsePosition(0));
			if(!fechaNormalizada.before(hoy)) {
				lista.add(Utilerias.mapconvertEntityConfiguracionVtaToJson(configuracionVenta));
			}
		}
		// TODO Auto-generated method stub
		return lista;
	}
	
}
