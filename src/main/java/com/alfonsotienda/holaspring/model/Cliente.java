package com.alfonsotienda.holaspring.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.validation.constraints.*;
import javax.persistence.*;



import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Cliente - creamos este objeto
 */

// Para generar objeto o tabla en base de dato usamos la siguiente etiqueta 
@Entity
@Table(name="Cliente")
public class Cliente {

 // para indicar la primary key PK y no nula  
   @Id
 // para hacer la id auto_incrment  
   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;


// para hacer el NOT NULL
// otra forma es @Column(name="nombre", nullable =  false , unique = true )	
// para determinar la longitud de la cadena con un min y un max @Size
	@NotNull
    @Size(max = 40)
	private String nombre;
   
	@Size(min = 2, max = 10)
	private String sociedad;
	
	// limites para numeros en este caso es facturacion pero podria ser edad por ejemplo
	@Min(value=100)  
	@Max(value=1000000000)
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

	
	public Cliente( String nombre, String sociedad, Double totalfacturacion) {	
		this.nombre = nombre;
		this.sociedad = sociedad;
		this.totalfacturacion = totalfacturacion;
	}
	
// generar constructor boton derecho sourcer action - generar y seleccionar todo
  
// como hemos generado el id auto_increment no seria necesario incluirlo en el constructor 
    

    
}









































