package com.ventas.repository;

import org.springframework.data.repository.CrudRepository;

import com.ventas.entity.Factura;

public interface FacturasRepository extends CrudRepository<Factura, Integer> {
}
