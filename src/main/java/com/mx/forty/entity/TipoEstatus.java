package com.mx.forty.entity;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class TipoEstatus {
	
	@Id
	private Integer idTipoEstatus;
	private String clave;
	private String nombre;
	
	public Integer getIdTipoEstatus() {
		return idTipoEstatus;
	}
	public void setIdTipoEstatus(Integer idTipoEstatus) {
		this.idTipoEstatus = idTipoEstatus;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
