package com.mx.forty.dto.vo;

import java.io.Serializable;
import java.util.Date;

public class ConfiguracionVentaVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idConfiguracionVenta;
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private Double previoVenta;
	private Integer idEstatus;
	private String nombreEstatus;
	private Integer idTipoConfiguracion;
	public Integer getIdTipoConfiguracion() {
		return idTipoConfiguracion;
	}
	public void setIdTipoConfiguracion(Integer idTipoConfiguracion) {
		this.idTipoConfiguracion = idTipoConfiguracion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getIdConfiguracionVenta() {
		return idConfiguracionVenta;
	}
	public void setIdConfiguracionVenta(Integer idConfiguracionVenta) {
		this.idConfiguracionVenta = idConfiguracionVenta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Double getPrevioVenta() {
		return previoVenta;
	}
	public void setPrevioVenta(Double previoVenta) {
		this.previoVenta = previoVenta;
	}
	public Integer getIdEstatus() {
		return idEstatus;
	}
	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}
	public String getNombreEstatus() {
		return nombreEstatus;
	}
	public void setNombreEstatus(String nombreEstatus) {
		this.nombreEstatus = nombreEstatus;
	}
}
