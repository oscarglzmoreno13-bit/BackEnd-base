package com.mx.forty.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tipo_forma_pago")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoFormaPago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_forma_pago")
	private Integer idTipoFormaPago;
	
	@Column(name = "nombre")
	private String nombre;
	
	public Integer getIdTipoFormaPago() {
		return idTipoFormaPago;
	}
	public void setIdTipoFormaPago(Integer idTipoFormaPago) {
		this.idTipoFormaPago = idTipoFormaPago;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
