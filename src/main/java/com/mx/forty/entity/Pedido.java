package com.mx.forty.entity;

import java.util.Date;

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
@Table(name = "pedido")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
	private Integer idPedido;
	
	@Column(name = "fecha")
	private Date fecha;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private Persona usuario;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_cliente", referencedColumnName = "id_usuario")
	private Persona cliente;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_forma_pago", referencedColumnName = "id_forma_pago")
	private FormaPago formaPago;
	
	@Column(name = "link_pago")
	private String linkPago;
	
	@Column(name = "monto_total")
	private Double montoTotal;
	
	@Column(name = "observaciones")
	private String observaciones;
	
	@Column(name = "numero_guia")
	private String numeroGuia;
	
	@Column(name = "fecha_entrega_apx")
	private Date fechaEntregaAprox;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_estatus", referencedColumnName = "id_estatus")
	private Estatus estatus;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_direccion_pedido", referencedColumnName = "id_direccion_pedido")
	private DireccionPedido direccionPedido;

	 public Integer getIdPedido() {
		 return idPedido;
	 }

	 public void setIdPedido(Integer idPedido) {
		 this.idPedido = idPedido;
	 }

	 public Date getFecha() {
		 return fecha;
	 }

	 public void setFecha(Date fecha) {
		 this.fecha = fecha;
	 }

	 public Persona getUsuario() {
		 return usuario;
	 }

	 public void setUsuario(Persona usuario) {
		 this.usuario = usuario;
	 }

	 public Persona getCliente() {
		 return cliente;
	 }

	 public void setCliente(Persona cliente) {
		 this.cliente = cliente;
	 }

	 public FormaPago getFormaPago() {
		 return formaPago;
	 }

	 public void setFormaPago(FormaPago formaPago) {
		 this.formaPago = formaPago;
	 }

	 public String getLinkPago() {
		 return linkPago;
	 }

	 public void setLinkPago(String linkPago) {
		 this.linkPago = linkPago;
	 }

	 public Double getMontoTotal() {
		 return montoTotal;
	 }

	 public void setMontoTotal(Double montoTotal) {
		 this.montoTotal = montoTotal;
	 }

	 public String getObservaciones() {
		 return observaciones;
	 }

	 public void setObservaciones(String observaciones) {
		 this.observaciones = observaciones;
	 }

	 public String getNumeroGuia() {
		 return numeroGuia;
	 }

	 public void setNumeroGuia(String numeroGuia) {
		 this.numeroGuia = numeroGuia;
	 }

	 public Date getFechaEntregaAprox() {
		 return fechaEntregaAprox;
	 }

	 public void setFechaEntregaAprox(Date fechaEntregaAprox) {
		 this.fechaEntregaAprox = fechaEntregaAprox;
	 }

	 public Estatus getEstatus() {
		 return estatus;
	 }

	 public void setEstatus(Estatus estatus) {
		 this.estatus = estatus;
	 }

	 public DireccionPedido getDireccionPedido() {
		 return direccionPedido;
	 }

	 public void setDireccionPedido(DireccionPedido direccionPedido) {
		 this.direccionPedido = direccionPedido;
	 }
	
	
}
