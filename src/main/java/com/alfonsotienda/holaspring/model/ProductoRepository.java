package com.alfonsotienda.holaspring.model;

import com.alfonsotienda.holaspring.model.Cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer>{

 //   Iterable<Producto> findByName(String name);
    
 }