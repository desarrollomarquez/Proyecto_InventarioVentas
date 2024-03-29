package com.ventas.util;

import com.ventas.model.Producto;

public class ProductoVenta extends Producto {
	
    private Float cantidad;

    public ProductoVenta(String nombre, String codigo, Float precio, Float existencia, Integer id, Float cantidad) {
        super(nombre, codigo, precio, existencia, id);
        this.cantidad = cantidad;
    }
    

    public ProductoVenta(String nombre, String codigo, Float precio, Float existencia, Float cantidad) {
        super(nombre, codigo, precio, existencia);
        this.cantidad = cantidad;
    }

    public void aumentarCantidad() {
        this.cantidad++;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public Float getTotal() {
        return this.getPrecio() * this.cantidad;
    }
}
