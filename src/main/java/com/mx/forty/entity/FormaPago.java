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
@Table(name = "forma_pago")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FormaPago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forma_pago")
	private Integer idFormaPago;
	
	@Column(name = "nombre") 
	private String nombre;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_tipo_forma_pago", referencedColumnName = "id_tipo_forma_pago")
	private TipoFormaPago tipoFormaPago;
	 
	public Integer getIdFormaPago() {
		return idFormaPago;
	}
	public void setIdFormaPago(Integer idFormaPago) {
		this.idFormaPago = idFormaPago;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public TipoFormaPago getTipoFormaPago() {
		return tipoFormaPago;
	}
	public void setTipoFormaPago(TipoFormaPago tipoFormaPago) {
		this.tipoFormaPago = tipoFormaPago;
	}
	
}
