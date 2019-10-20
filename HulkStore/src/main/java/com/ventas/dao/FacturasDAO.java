package com.ventas.dao;

import org.springframework.data.repository.CrudRepository;

import com.ventas.model.Factura;

public interface FacturasDAO extends CrudRepository<Factura, Integer> {
}
