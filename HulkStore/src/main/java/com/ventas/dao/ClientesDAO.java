package com.ventas.dao;

import org.springframework.data.repository.CrudRepository;

import com.ventas.model.Cliente;

public interface ClientesDAO extends CrudRepository<Cliente, Integer> {

  //  Cliente findFirstByNumeroId(String numeroid);
    
}
