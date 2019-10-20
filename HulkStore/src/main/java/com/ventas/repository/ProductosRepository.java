package com.ventas.repository;

import org.springframework.data.repository.CrudRepository;

import com.ventas.entity.Producto;

public interface ProductosRepository extends CrudRepository<Producto, Integer> {

    Producto findFirstByCodigo(String codigo);
}
