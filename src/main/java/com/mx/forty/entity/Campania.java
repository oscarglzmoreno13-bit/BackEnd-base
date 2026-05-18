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
@Table(name = "Campania")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Campania {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_campania")
	private Integer idCampania;
	
	@Column(name = "nombre") 
	private String nombre;
	
	@Column(name = "descripcion") 
	private String descripcion;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_estatus", referencedColumnName = "id_estatus")
    private Estatus estatus;
	 
	 @Column(name = "fecha_inicio")
	 private Date fechaInicio;
	 
	 @Column(name = "fecha_fin")
	 private Date fechaFin;

	 public Integer getIdCampania() {
		 return idCampania;
	 }

	 public void setIdCampania(Integer idCampania) {
		 this.idCampania = idCampania;
	 }

	 public String getNombre() {
		 return nombre;
	 }

	 public void setNombre(String nombre) {
		 this.nombre = nombre;
	 }

	 public String getDescripcion() {
		 return descripcion;
	 }

	 public void setDescripcion(String descripcion) {
		 this.descripcion = descripcion;
	 }

	 public Estatus getEstatus() {
		 return estatus;
	 }

	 public void setEstatus(Estatus estatus) {
		 this.estatus = estatus;
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
}
