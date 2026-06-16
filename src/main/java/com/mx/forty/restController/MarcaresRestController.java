package com.mx.forty.restController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.forty.dto.vo.MarcaVo;
import com.mx.forty.entity.Marca;
import com.mx.forty.service.MarcaService;

@RestController
@RequestMapping("/api/marcas")
public class MarcaresRestController {
	 @Autowired
	    private MarcaService service;

	    @GetMapping
	    public List<Marca> findAll() {
	        return service.findAll();
	    }

	    @PostMapping
	    public void save(@RequestBody Marca marca) {
	        service.save(marca);
	    }
	    
	    @PostMapping("/delete")
		public void deleteMarca(@RequestBody MarcaVo vo) {
	    	service.delete(vo);
	    }
		
}
