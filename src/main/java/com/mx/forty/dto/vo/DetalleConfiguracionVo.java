package com.mx.forty.dto.vo;

public class DetalleConfiguracionVo {
	


	private Integer idDetalleConfiguracion;
	private Integer idProducto;
	private String nombreProducto;
	private Integer cantidad;
	private Integer idConfiguracion;
	public Integer getIdDetalleConfiguracion() {
		return idDetalleConfiguracion;
	}
	public void setIdDetalleConfiguracion(Integer idDetalleConfiguracion) {
		this.idDetalleConfiguracion = idDetalleConfiguracion;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getIdConfiguracion() {
		return idConfiguracion;
	}
	public void setIdConfiguracion(Integer idConfiguracion) {
		this.idConfiguracion = idConfiguracion;
	}


}
