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
@Table(name = "colonia")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Colonia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colonia")
	private Integer idColonia;
	
	@Column(name = "nombre") 
	private String nombre;
	
	@Column(name = "codigo_postal")
	private String codigoPostal;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mcpio", referencedColumnName = "id_municipio")
	private Municipio municipio;
	public Integer getIdColonia() {
		return idColonia;
	}
	public void setIdColonia(Integer idColonia) {
		this.idColonia = idColonia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
}
