package com.alfonsotienda.holaspring.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Factura - creamos este objeto
 */

// Para generar objeto en base de dato usamos la siguiente etiqueta 
@Entity

public class Factura {

 // para indicar la primary key PK   
   @Id
    private Integer id;
    
    private String fecha;
    
    private Double total;


// generamos getters and setters con boton derecho source action - generar (seleccionamos todo)

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
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
















































