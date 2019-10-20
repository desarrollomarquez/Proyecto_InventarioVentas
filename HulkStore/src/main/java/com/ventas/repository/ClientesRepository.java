package com.ventas.repository;

import org.springframework.data.repository.CrudRepository;

import com.ventas.entity.Cliente;

public interface ClientesRepository extends CrudRepository<Cliente, Integer> {

  //  Cliente findFirstByNumeroId(String numeroid);
    
}
