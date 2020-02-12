package com.alfonsotienda.holaspring.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Factura - creamos este objeto
 */

// Para generar objeto en base de dato usamos la siguiente etiqueta 
@Entity

public class Cliente {

 // para indicar la primary key PK   
   @Id
 // para hacer la id auto_incrment  
   @GeneratedValue(strategy=GenerationType.IDENTITY)
// para hacer la id NOT NULL
   @Column(name="id", nullable =  false , unique = true )
	private Integer id;
// para determinar la longitud de la cadena con un min y un max 
	@Size(min = 5, max = 40)
	private String nombre;
    @Size(min = 2, max = 10)
    private String sociedad;
    private Double totalfacturacion;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getTotalfacturacion() {
		return totalfacturacion;
	}

	public void setTotalfacturacion(Double total) {
		this.totalfacturacion = total;
	}
      

    public String getSociedad() {
		return sociedad;
	}

	public void setSociedad(String sociedad) {
		this.sociedad = sociedad;
	}

	
	public Cliente(Integer id, String nombre, String sociedad, Double totalfacturacion) {
		this.id = id;
		this.nombre = nombre;
		this.sociedad = sociedad;
		this.totalfacturacion = totalfacturacion;
	}
	
// generar constructor boton derecho sourcer action - generar y seleccionar todo
  
// como hemos generado el id auto_increment no seria necesario incluirlo en el constructor 
    

    
}









































