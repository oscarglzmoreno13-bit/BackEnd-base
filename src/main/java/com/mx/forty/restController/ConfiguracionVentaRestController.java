package com.mx.forty.restController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.forty.service.ConfiguracionVentaService;

@RestController
@RequestMapping("/api/configuraciones")
public class ConfiguracionVentaRestController {

	/**
	 * 
	 */

	@Autowired ConfiguracionVentaService service;
	
	 @GetMapping("/findAll")
	    public List<Map<String, Object>> findAll() {
	        return service.finAll();
	    }
	 
	 @PostMapping("/save")
	 public ResponseEntity<Map<String, Object>> save(@RequestBody Map<String, Object> map) {
	     try {
	         service.save(map);
	         return ResponseEntity.ok(map);
	     } catch(Exception e) {
	         return ResponseEntity.badRequest().build();
	     }
	 }

	 
	 @PostMapping("/delete")
	    public void delete(@RequestBody Map<String, Object> map) {
	    	try {
	    		service.delete(map);
	    	} catch (Exception e) {
				// TODO: handle exception
	    		throw new IllegalArgumentException("Error al eliminar el registro");
			}
	    }
	 
	 @GetMapping("/findActivesByCampania")
	 public List<Map<String, Object>> findConafiguracionesByCampania(@RequestParam Integer idCampania) {
		 return service.findConfiguracionesByCampania(idCampania);
	 }
	
}
