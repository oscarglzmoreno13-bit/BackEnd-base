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
@Table(name = "detalle_pedido")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DetallePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_pedido")
	private Integer idDetallePedido;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido", nullable = false)
	private Pedido pedido;
	
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_configuracion", referencedColumnName = "id_configuracion_venta")
	private ConfiguracionVenta configuracion;
	public Integer getIdDetallePedido() {
		return idDetallePedido;
	}
	public void setIdDetallePedido(Integer idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}
	public ConfiguracionVenta getConfiguracion() {
		return configuracion;
	}
	public void setConfiguracion(ConfiguracionVenta configuracion) {
		this.configuracion = configuracion;
	}
}
