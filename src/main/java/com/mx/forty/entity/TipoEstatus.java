package com.mx.forty.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tipo_estatus")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoEstatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_estatus")
	private Integer idTipoEstatus;
	
	@Column(name = "clave")
	private String clave;
	
	@Column(name = "nombre")
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
