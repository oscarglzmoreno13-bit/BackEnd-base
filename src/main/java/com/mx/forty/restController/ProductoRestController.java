package com.mx.forty.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.forty.dto.vo.ProductoVo;
import com.mx.forty.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

	@Autowired
	private ProductoService service;
	
	@GetMapping
	public List<ProductoVo> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/getUpc")
	public List<String> findAllUpc() {
		return service.findAllUpc();
	}
	
	 @PostMapping
    public void save(@RequestBody ProductoVo prod) {
        try {
        	service.save(prod);
        } catch(Exception e) {
        	throw new IllegalArgumentException(e.getMessage());
        }
    } 
	 
	 @PostMapping("/delete")
	 public void delete(@RequestBody ProductoVo prod) {
	     try {
	         service.deleteProducto(prod.getIdProducto());
	     } catch (Exception e) {
	         throw new IllegalArgumentException(e.getMessage());
	     }
	 }
	 
	 @GetMapping("/findByIdMarca")
		public List<ProductoVo> findByIdMarca(@RequestBody Integer idMarca) {
			return service.findByIdMarca(idMarca);
		}

}
