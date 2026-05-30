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
@Table(name = "detalle_configuracion")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DetalleConfiguracionVenta {

	
	public Integer getIdDetalleConfiguracion() {
		return idDetalleConfiguracion;
	}
	public void setIdDetalleConfiguracion(Integer idDetalleConfiguracion) {
		this.idDetalleConfiguracion = idDetalleConfiguracion;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public ConfiguracionVenta getConfiguracion() {
		return configuracion;
	}
	public void setConfiguracion(ConfiguracionVenta configuracion) {
		this.configuracion = configuracion;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
	private Integer idDetalleConfiguracion;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
	private Producto producto;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	
	@ManyToOne
	@JoinColumn(name = "id_configuracion", nullable = false)
	private ConfiguracionVenta configuracion;
}
