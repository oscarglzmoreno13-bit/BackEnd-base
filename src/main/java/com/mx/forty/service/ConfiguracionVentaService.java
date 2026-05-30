package com.mx.forty.service;

import java.util.List;
import java.util.Map;

public interface ConfiguracionVentaService {

	public List<Map<String, Object>> finAll();
	
	public void save(Map<String, Object> json);
	
	public void delete(Map<String, Object> json);
	
	public List<Map<String, Object>> findConfiguracionesByCampania(Integer idCampania);
	
}
