package com.mx.forty.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "configuracion_venta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ConfiguracionVenta  {
	
	public Campania getCampania() {
		return campania;
	}

	public void setCampania(Campania campania) {
		this.campania = campania;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_configuracion_venta")
	private Integer idConfiguracionVenta;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "fecha_inicio")
	 private Date fechaInicio;
	 
	 @Column(name = "fecha_fin")
	 private Date fechaFin; 
	 
	 @Column(name = "precio_venta")
	 private Double precioVenta;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_estatus", referencedColumnName = "id_estatus")
	 private Estatus estatus;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_tipo_configuracion", referencedColumnName = "id_tipo_comfiguracion")
	 private TipoConfiguracion tipoConfiguracion;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_campania", referencedColumnName = "id_campania")
	 private Campania campania;
	
	 @OneToMany(mappedBy = "configuracion", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	 private List<DetalleConfiguracionVenta> detallesConfiguracion;

	
	 public List<DetalleConfiguracionVenta> getDetallesConfiguracion() {
		return detallesConfiguracion;
	}

	 public void setDetallesConfiguracion(List<DetalleConfiguracionVenta> detallesConfiguracion) {
		 this.detallesConfiguracion = detallesConfiguracion;
	 }

	 public Integer getIdConfiguraciónVenta() {
		 return idConfiguracionVenta;
	 }

	 public void setIdConfiguraciónVenta(Integer idConfiguraciónVenta) {
		 this.idConfiguracionVenta = idConfiguraciónVenta;
	 }

	 public String getNombre() {
		 return nombre;
	 }

	 public void setNombre(String nombre) {
		 this.nombre = nombre;
	 }

	 public Date getFechaInicio() {
		 return fechaInicio;
	 }

	 public void setFechaInicio(Date fechaInicio) {
		 this.fechaInicio = fechaInicio;
	 }

	 public Date getFechaFin() {
		 return fechaFin;
	 }

	 public void setFechaFin(Date fechaFin) {
		 this.fechaFin = fechaFin;
	 }

	 public Double getPrecioVenta() {
		 return precioVenta;
	 }

	 public void setPrecioVenta(Double precioVenta) {
		 this.precioVenta = precioVenta;
	 }

	 public Estatus getEstatus() {
		 return estatus;
	 }

	 public void setEstatus(Estatus estatus) {
		 this.estatus = estatus;
	 }

	 public TipoConfiguracion getTipoConfiguracion() {
		 return tipoConfiguracion;
	 }

	 public void setTipoConfiguracion(TipoConfiguracion tipoConfiguracion) {
		 this.tipoConfiguracion = tipoConfiguracion;
	 }
	 

}
