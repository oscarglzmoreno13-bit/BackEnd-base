package com.mx.forty.restController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.forty.service.CampaniaService;

@RestController
@RequestMapping("/api/campanias")
public class CampaniaRestController {

	 @Autowired
	private CampaniaService service;
	 
	 @GetMapping
	    public List<Map<String, Object>> findAll() {
	        return service.finAll();
	    }
	 
	 @PostMapping("/save")
	 public ResponseEntity<Map<String, Object>> save(@RequestBody Map<String, Object> map) {
	     try {
	    	 System.out.println("");
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
}
