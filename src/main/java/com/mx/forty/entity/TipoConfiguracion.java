package com.mx.forty.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_configuracion")
public class TipoConfiguracion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_comfiguracion")
	private Integer idTipoConfiguracion;
	
	 @Column(name = "CLAVE")
	private String clave;
	 
	 @Column(name = "nombre")
	private String nombre;
	
	public Integer getIdTipoConfiguracion() {
		return idTipoConfiguracion;
	}
	public void setIdTipoConfiguracion(Integer idTipoConfiguracion) {
		this.idTipoConfiguracion = idTipoConfiguracion;
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
