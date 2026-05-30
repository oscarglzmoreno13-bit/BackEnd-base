package com.mx.forty.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.forty.dto.vo.CampaniaVo;
import com.mx.forty.entity.Campania;
import com.mx.forty.entity.Estatus;
import com.mx.forty.repository.CampaniaRepository;
import com.mx.forty.service.CampaniaService;
import com.mx.forty.util.Constantes;
import com.mx.forty.util.Utilerias;

@Service
public class CampaniaServiceImpl implements CampaniaService {

	@Autowired
	CampaniaRepository repository;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy, HH:mm");
	
	@Override
	public List<Map<String, Object>> finAll() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> lst = new ArrayList<>();
		List<Campania> lista = repository.findAllActives();
		for (Campania campania : lista) {
			try {
				lst.add(Utilerias.convertCampaniaVoToJson(getEntityToVo(campania)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return lst; 
	}

	private CampaniaVo getEntityToVo(Campania campania) throws ParseException {
		// TODO Auto-generated method stub
		CampaniaVo vo = new CampaniaVo();
		vo.setDescripcion(campania.getDescripcion());
		vo.setIdCampania(campania.getIdCampania());
		vo.setNombre(campania.getNombre());
		vo.setIdEstatus(campania.getEstatus().getIdEstatus());
		vo.setNombreEstatus(campania.getEstatus().getNombre());
		vo.setFechaInicio(new Date(campania.getFechaInicio().getTime()));
		vo.setFechaFin(new Date(campania.getFechaFin().getTime()));
		return vo;
	}//509551F66EDF

	@Override
	public void save(Map<String, Object> json) {
		// TODO Auto-generated method stub
		Campania camp = Utilerias.convertJsonToCampania(json);
		List<Campania> lista = repository.validaCampaniaExistente((String) json.get("nombre"));
		if(lista==null || (lista!=null && lista.isEmpty())) {
			repository.save(camp);
		} else {
			if(lista!=null && lista.isEmpty()) {
				if(camp.getIdCampania()==null) {
					throw new IllegalArgumentException("Los datos  ya existen en BD");
				} else {
					for (Campania campania : lista) {
						if(campania.getIdCampania().equals(camp.getIdCampania())) {
							repository.save(camp);
						} else {
							throw new IllegalArgumentException("Los datos  ya existen en BD");
						}
					}
					throw new IllegalArgumentException("Los datos  ya existen en BD");
				}
			}
		}
	}
	
	@Override
	public void delete(Map<String, Object> json) {
		// TODO Auto-generated method stub
		Campania campania = Utilerias.convertJsonToCampania(json);
		campania.getEstatus().setIdEstatus(Constantes.ESTATUS_GRAL_INACTIVO);
		repository.save(campania);
	}

	private Campania getVotoEntity(CampaniaVo vo, SimpleDateFormat sdf) {
		try {
			Campania campania = new Campania();
			campania.setDescripcion(vo.getDescripcion());
			campania.setFechaFin(vo.getFechaFin());
			campania.setFechaInicio(vo.getFechaInicio());
			campania.setIdCampania(vo.getIdCampania());
			campania.setEstatus(new Estatus());
			campania.getEstatus().setIdEstatus(Constantes.ESTATUS_GRAL_ACTIVO);
			campania.setNombre(vo.getNombre());
			// TODO Auto-generated method stub
			return campania;
		} catch(Exception e) {
			throw new IllegalArgumentException("Los datos  ya existen en BD");
		}
	}

}
