package com.alfonsotienda.holaspring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * FacturaRepository- este objeto sirve para guardar, consultar y manejar datos
 */

// la interfaz la hace spring

@Repository

 public interface FacturaRepository 
     extends CrudRepository<Factura, Integer>{
 
     
 }
     
 










