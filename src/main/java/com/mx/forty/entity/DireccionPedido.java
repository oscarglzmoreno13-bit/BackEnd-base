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
@Table(name = "direccion_pedido")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DireccionPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion_pedido")
	private Integer idDireccionPedido;
	
	@Column(name = "calle_uno")
	private String calleUno;
	
	@Column(name = "calle_dos")
	private String entreCalles;
	
	@Column(name = "referencias")
	private String referencias;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_colonia", referencedColumnName = "id_colonia")
	private Colonia colonia;
	
	@Column(name = "numero_exterior")
	private String numeroExterior;
	
	@Column(name = "numero_interior")
	private String numeroInterior;

	public Integer getIdDireccionPedido() {
		return idDireccionPedido;
	}

	public void setIdDireccionPedido(Integer idDireccionPedido) {
		this.idDireccionPedido = idDireccionPedido;
	}

	public String getCalleUno() {
		return calleUno;
	}

	public void setCalleUno(String calleUno) {
		this.calleUno = calleUno;
	}

	public String getEntreCalles() {
		return entreCalles;
	}

	public void setEntreCalles(String entreCalles) {
		this.entreCalles = entreCalles;
	}

	public String getReferencias() {
		return referencias;
	}

	public void setReferencias(String referencias) {
		this.referencias = referencias;
	}

	public Colonia getColonia() {
		return colonia;
	}

	public void setColonia(Colonia colonia) {
		this.colonia = colonia;
	}

	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public String getNumeroInterior() {
		return numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}
}
