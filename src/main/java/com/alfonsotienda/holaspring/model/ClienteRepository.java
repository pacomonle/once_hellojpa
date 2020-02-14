package com.alfonsotienda.holaspring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/*
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

   Iterable<Cliente> findByName(String name);
    
 }
*/


 @Repository

 public interface ClienteRepository 
     extends CrudRepository<Cliente, Integer>{
 
     
 }
     
 


