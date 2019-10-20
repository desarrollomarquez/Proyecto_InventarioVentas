package com.ventas.model;

import javax.persistence.*;

@Entity
@Table(name="detalle")
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Float cantidad, precio;
    private String nombre, codigo;
    
	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="factura_id")
	private Factura factura;
    
	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="producto_id")
	private Producto producto;
	    

    public Detalle(Float cantidad, Float precio, String nombre, String codigo, Factura factura, Producto producto) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombre = nombre;
        this.codigo = codigo;
        this.factura = factura;
        this.producto = producto;
    }

    public Detalle() {
    }

    
    public Float getTotal() {
        return this.cantidad * this.precio;
    }


    public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
