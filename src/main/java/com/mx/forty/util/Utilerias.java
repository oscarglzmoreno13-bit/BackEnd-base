package com.mx.forty.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mx.forty.dto.vo.CampaniaVo;
import com.mx.forty.dto.vo.DetalleConfiguracionVo;
import com.mx.forty.dto.vo.PagoEcartPayVo;
import com.mx.forty.dto.vo.PersonaBackVo;
import com.mx.forty.entity.Campania;
import com.mx.forty.entity.Colonia;
import com.mx.forty.entity.ConfiguracionVenta;
import com.mx.forty.entity.DetalleConfiguracionVenta;
import com.mx.forty.entity.DireccionPedido;
import com.mx.forty.entity.Estatus;
import com.mx.forty.entity.FormaPago;
import com.mx.forty.entity.Pedido;
import com.mx.forty.entity.Persona;
import com.mx.forty.entity.Producto;
import com.mx.forty.entity.TipoConfiguracion;

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
	
	public static ConfiguracionVenta convertJstonToEntityConfiguracionVta(Map<String, Object> map) {
		ConfiguracionVenta configuracion = new ConfiguracionVenta();
		configuracion.setNombre((String) map.get("nombre"));
		configuracion.setIdConfiguraciónVenta((Integer) map.get("idConfiguracionVenta"));
		configuracion.setPrecioVenta((Double) map.get("precio"));
		try {
			ZonedDateTime zdt = null;
			zdt =  ZonedDateTime.parse((String) map.get("fechaInicio"), DateTimeFormatter.ISO_ZONED_DATE_TIME);
			configuracion.setFechaInicio(Date.from(zdt.toInstant()));
			zdt =  ZonedDateTime.parse((String) map.get("fechaFin"), DateTimeFormatter.ISO_ZONED_DATE_TIME);
			configuracion.setFechaFin(Date.from(zdt.toInstant()));
		} catch(Exception e) {
			configuracion.setFechaInicio(new Date());
			configuracion.setFechaFin(new Date());
		}
		configuracion.setTipoConfiguracion(new TipoConfiguracion());
		configuracion.getTipoConfiguracion().setIdTipoConfiguracion((Integer) map.get("idTipoConfiguracion"));
		configuracion.setCampania(new Campania());
		configuracion.getCampania().setIdCampania((Integer) map.get("idCampania"));
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> lista = (List<Map<String, Object>>) map.get("listaProductos");
		configuracion.setDetallesConfiguracion(new ArrayList<DetalleConfiguracionVenta>());
		for (Map<String, Object> detalleMap : lista) {
			DetalleConfiguracionVenta detalle = convertJsonToEntityDetalleConfiguracion(detalleMap);
			configuracion.getDetallesConfiguracion().add(detalle);
		}
		return configuracion;
	}
	
	public static Map<String, Object> mapconvertEntityConfiguracionVtaToJson(ConfiguracionVenta configuracion) {
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy, HH:mm");
		map.put("idConfiguracion", configuracion.getIdConfiguraciónVenta());
		map.put("nombre", configuracion.getNombre());
		map.put("nombreCampania", configuracion.getCampania().getNombre());
		map.put("idCampania", configuracion.getCampania().getIdCampania());
		map.put("fechaInicio", sdf.format(configuracion.getFechaInicio()));
		map.put("fechaFin", sdf.format(configuracion.getFechaFin()));
		map.put("precio", configuracion.getPrecioVenta());
		map.put("idTipoConfiguracion", configuracion.getTipoConfiguracion().getIdTipoConfiguracion());
		map.put("ombreTipoConfiguracion", configuracion.getTipoConfiguracion().getNombre());
		map.put("nombreTipoConfiguracion", configuracion.getTipoConfiguracion().getNombre());
		List<Map<String, Object>> listaDetalle = new ArrayList<Map<String, Object>>();
		for (DetalleConfiguracionVenta detalle : configuracion.getDetallesConfiguracion()) {
			listaDetalle.add(convetEntityDetalleConfiguracionToJson(detalle));
		}
		map.put("listaProductos", listaDetalle);
		return map;
	}
	
	public static DetalleConfiguracionVenta convertJsonToEntityDetalleConfiguracion(Map<String, Object> map) {
		DetalleConfiguracionVenta detalle = new DetalleConfiguracionVenta();
		detalle.setIdDetalleConfiguracion((Integer) map.get("idDetalleConfiguracion"));
		detalle.setCantidad((Integer) map.get("cantidad"));
		detalle.setProducto(new Producto());
		detalle.getProducto().setIdProducto((Integer) map.get("idProducto"));
		return detalle;
	}
	
	public static  Map<String, Object> convetEntityDetalleConfiguracionToJson(DetalleConfiguracionVenta detalle) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idConfiguracion", detalle.getConfiguracion().getIdConfiguraciónVenta());
		map.put("cantidad", detalle.getCantidad());
		map.put("idDetalleConfiguracion",detalle.getIdDetalleConfiguracion() );
		map.put("nombreProducto",detalle.getProducto().getNombre() );
		map.put("idProducto", detalle.getProducto().getIdProducto());
		return map;
	}
	
	public DetalleConfiguracionVo convetEntityDetalleConfiguracionToVo(DetalleConfiguracionVenta detalle) {
		
		DetalleConfiguracionVo vo = new DetalleConfiguracionVo();
		vo.setIdConfiguracion(detalle.getConfiguracion().getIdConfiguraciónVenta());
		vo.setCantidad(detalle.getCantidad());
		vo.setIdDetalleConfiguracion(detalle.getIdDetalleConfiguracion());
		vo.setIdProducto(detalle.getProducto().getIdProducto());
		vo.setNombreProducto(detalle.getProducto().getNombre());
		return vo;
	}
	
	public static Persona convertJsonToVoPersonaEntity(Map<String, Object> map) {
		Persona persona = new Persona();
		persona.setIdPersona((Integer) map.get("idPersona"));
		persona.setNombre((String) map.get("nombre"));
		persona.setApellidoPat((String) map.get("apePat"));
		persona.setApellidoMat((String) map.get("apeMat"));
		persona.setTelefono((String) map.get("telefono"));
		persona.setMail((String) map.get("correo"));
		return persona;	
	}
	
	public static DireccionPedido convertJsonToDireccionEntity(Map<String, Object> map) {
		DireccionPedido direccion = new DireccionPedido();
		direccion.setIdDireccionPedido((Integer) map.get("idDireccionPedido"));
		direccion.setCalleUno((String) map.get("calle"));
		direccion.setEntreCalles((String) map.get("entreCalles"));
		direccion.setColonia(new Colonia());
		direccion.getColonia().setIdColonia((Integer) map.get("idColonia"));
		direccion.setNumeroExterior((String) map.get("numExgterior"));
		direccion.setNumeroInterior((String) map.get("numInterior"));
		direccion.setReferencias((String) map.get("referencias"));
		return direccion;
	}
	
	public static Pedido convertJsonToPedidoEntity(Map<String, Object>map) {
		Pedido pedido = new Pedido();
		pedido.setFormaPago(new FormaPago());
		pedido.getFormaPago().setIdFormaPago((Integer) map.get("idFormaPago"));
		pedido.setLinkPago((String) map.get("linkPago"));
		pedido.setMontoTotal((Double) map.get("monto"));
		pedido.setObservaciones((String) map.get("observaciones"));
		
		return pedido;
	}
	
	public static PagoEcartPayVo convertMapToPAgoVo(Map<String, Object> map) {
		PagoEcartPayVo vo = new PagoEcartPayVo();
		vo.setLastName((String) map.get("lastName"));
		vo.setMonto((Double) map.get("monto"));
		vo.setNombre((String) map.get("nombre"));
		vo.setTelefono((String) map.get("telefono"));
		vo.setPedidoEcarpay((String) map.get("orderNum"));
		return vo;
	}
	
	
}
