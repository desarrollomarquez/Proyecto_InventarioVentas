package com.ventas.dao;

import org.springframework.data.repository.CrudRepository;

import com.ventas.model.Detalle;

public interface DetallesDAO extends CrudRepository<Detalle, Integer> {

}
