package com.mx.forty.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.forty.dto.vo.TipoConfiguracionVo;
import com.mx.forty.service.TipoConfiguracionService;

@RestController
@RequestMapping("/api/tipoConfiguracion")
public class TipoConfiguracionRestController {

	@Autowired
	TipoConfiguracionService service;
	
	@GetMapping
    public List<TipoConfiguracionVo> findAll() {
        return service.findAll();
    }
}
