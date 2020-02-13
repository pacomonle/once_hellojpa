package com.alfonsotienda.holaspring.model;

import com.alfonsotienda.holaspring.model.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * FacturaRepository- este objeto sirve para guardar, consultar y manejar datos
 */

// la interfaz la hace spring

@Repository

 public interface ClienteRepository 
     extends CrudRepository<Cliente, Integer>{
       @Override
        Iterable<Cliente> findAll();
        
     //   Iterable<Cliente> findByName(String name);
       
 
     
 }
     
 



