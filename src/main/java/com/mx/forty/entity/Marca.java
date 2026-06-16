package com.mx.forty.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Marca")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
	private Integer idMarca;
	
	 @Column(name = "CLAVE")
	private String clave;
	 
	 @Column(name = "nombre") 
	private String nombre;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_estatus", referencedColumnName = "id_estatus")
	private Estatus estatus;
	
	public Estatus getEstatus() {
		return estatus;
	}
	 public void setEstatus(Estatus estatus) {
		 this.estatus = estatus;
	 }
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
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
