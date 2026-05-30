package com.mx.forty.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.forty.dto.vo.ColoniaBackVo;
import com.mx.forty.dto.vo.EstadoBackVo;
import com.mx.forty.dto.vo.FormaPagoBackVo;
import com.mx.forty.dto.vo.MiunicipioBackVo;
import com.mx.forty.dto.vo.PersonaBackVo;
import com.mx.forty.dto.vo.TipoFormaPagoBackVo;
import com.mx.forty.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRestController {

	@Autowired
	private PedidoService service;
	
	@GetMapping("/findEdos")
	public List<EstadoBackVo> buscaEstrados() {
		return service.buscaEstrados();
	}
	
	@GetMapping("/findMcpiosByIdEdo")
	public List<MiunicipioBackVo> findMcpioByIdEstado(@RequestParam Integer idEstado) {
		return service.findMcpioByIdEstado(idEstado);
	}
	
	@GetMapping("/findColByIdMcpio")
	public List<ColoniaBackVo> findColoniaByIdMcpio(@RequestParam Integer idMcpio) {
		return service.findColoniaByIdMcpio(idMcpio);
	}
	
	@GetMapping("/findPersonaLikeNombre")
	public List<PersonaBackVo> findPersonaLikeNombre(@RequestParam String nombre) {
		return service.findLikeNombre(nombre);
	}
	
	@GetMapping("/findTipoFormaPago")
	public List<TipoFormaPagoBackVo> findTipoFormasPago() {
		return service.findTiposFormaPago();
	}
	
	@GetMapping("/findFormasPago")
	public List<FormaPagoBackVo> findFormasPago() {
		return service.findFormasPago();
	}
	
	@GetMapping("/buscaEjecutivos")
	public List<PersonaBackVo> buscaEjecutivos() {
		return service.buscaUsuarios();
	}
	
	@GetMapping("/buscaCodigosPostales")
	public List<String> buscaCodigosPostales() {
		return service.finsAllCp();
	}
	
	@GetMapping("/buscaColoniasByCp")
	public List<ColoniaBackVo> buscaColoniasByCp(@RequestParam String codigoPostal) {
		return service.findColoniasByCp(codigoPostal);
	}
}
