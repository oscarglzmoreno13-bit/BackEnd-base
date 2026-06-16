package com.mx.forty.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.mx.forty.dto.vo.ColoniaBackVo;
import com.mx.forty.dto.vo.EstadoBackVo;
import com.mx.forty.dto.vo.FormaPagoBackVo;
import com.mx.forty.dto.vo.MiunicipioBackVo;
import com.mx.forty.dto.vo.PersonaBackVo;
import com.mx.forty.dto.vo.TipoFormaPagoBackVo;
import com.mx.forty.util.ApiResponse;

public interface PedidoService {

	public List<EstadoBackVo> buscaEstrados();
	public List<MiunicipioBackVo> findMcpioByIdEstado(Integer idEstado);
	public List<ColoniaBackVo> findColoniaByIdMcpio(Integer idMcpio);
	public List<TipoFormaPagoBackVo> findTiposFormaPago();
	public List<FormaPagoBackVo> findFormasPago();
	public List<PersonaBackVo> findLikeNombre(String nombre);
	public List<PersonaBackVo> buscaUsuarios();
	public List<String> finsAllCp();
	public List<ColoniaBackVo> findColoniasByCp(String cp);
	public Map<String, Object> savePedido(Map<String, Object> map);
	public List<Map<String, Object>> findPedidos();
	public void generaOrdenEnvio(List<Map<String, Object>> listPedidos);
	public void updatePedido(Map<String, Object> map);
}
