package com.ventas.dao;

import org.springframework.data.repository.CrudRepository;

import com.ventas.model.Producto;

public interface ProductosDAO extends CrudRepository<Producto, Integer> {

    Producto findFirstByCodigo(String codigo);
}
