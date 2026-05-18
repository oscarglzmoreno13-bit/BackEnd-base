package com.mx.forty.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.mx.forty.dto.vo.CampaniaVo;
import com.mx.forty.entity.Campania;
import com.mx.forty.entity.Estatus;

public class Utilerias implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static  Map<String, Object> convertCampaniaVoToJson(CampaniaVo ui) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy, HH:mm");
		Map<String, Object> json = new HashMap<>();
	    json.put("idCampania", ui.getIdCampania());
	    json.put("nombre", ui.getNombre());
	    json.put("descripcion", ui.getDescripcion());
	    json.put("idEstatus", ui.getIdEstatus());
	    json.put("nombreEstatus", ui.getNombreEstatus());
	    json.put("fechaInicio", sdf.format(ui.getFechaInicio()));
	    json.put("fechaFin", sdf.format(ui.getFechaFin()));
	    return json;
	}
	
	public static Campania convertJsonToCampania(Map<String, Object> map) {
		Campania campania = new Campania();
		ZonedDateTime zdt = null;
		campania.setIdCampania(map.get("idCampania")==null?null:(Integer) map.get("idCampania"));
		campania.setDescripcion((String) map.get("descripcion"));
		campania.setEstatus(new Estatus());
		campania.getEstatus().setIdEstatus(map.get("idEstatus")==null?Constantes.ESTATUS_GRAL_ACTIVO:(Integer) map.get("idEstatus"));
		try {
			zdt =  ZonedDateTime.parse((String) map.get("fechaFin"), DateTimeFormatter.ISO_ZONED_DATE_TIME);
			campania.setFechaFin(Date.from(zdt.toInstant()));
			zdt =  ZonedDateTime.parse((String) map.get("fechaInicio"), DateTimeFormatter.ISO_ZONED_DATE_TIME);
			campania.setFechaInicio(Date.from(zdt.toInstant()));
		} catch(Exception e) {
			campania.setFechaFin(new Date());
			campania.setFechaInicio(new Date());
		}
		campania.setNombre((String) map.get("nombre"));
		return campania;
	}

}
