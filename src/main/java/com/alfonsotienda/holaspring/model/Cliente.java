package com.alfonsotienda.holaspring.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Factura - creamos este objeto
 */

// Para generar objeto en base de dato usamos la siguiente etiqueta 
@Entity

public class Cliente {

 // para indicar la primary key PK   
   @Id
    private Integer id;
    private String nombre;
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
	




    
     
     

	

  // generar constructor boton derecho sourcer action - generar y seleccionar todo
  
  /*
  
    public Factura(Integer id, String fecha, Double total) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
    }

   */ 
        
    

    
}









































