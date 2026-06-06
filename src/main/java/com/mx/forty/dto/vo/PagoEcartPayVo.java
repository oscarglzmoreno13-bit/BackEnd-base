package com.mx.forty.dto.vo;

public class PagoEcartPayVo {

	private String telefono;
	private String nombre;
	private String lastName;
	private Double monto;
	private String pedidoEcarpay;
	
	public String getPedidoEcarpay() {
		return pedidoEcarpay;
	}
	public void setPedidoEcarpay(String pedidoEcarpay) {
		this.pedidoEcarpay = pedidoEcarpay;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
}
