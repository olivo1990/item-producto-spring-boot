package com.springboot.app.itemproducto.models;

public class ItemPoducto {

	private Producto producto;
	private Integer cantidad;

	public ItemPoducto() {
	}

	public ItemPoducto(Producto producto, Integer cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
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
	
	public Double getTotal() {
		return producto.getPrecio() * this.cantidad.doubleValue();
	}
}
