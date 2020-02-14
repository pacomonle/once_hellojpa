paquete  com.alfonsotienda.holaspring.model ;

import  javax.persistence.Entity ;
import  javax.persistence.GeneratedValue ;
import  javax.persistence.GenerationType ;
import  javax.persistence.Id ;
import  javax.persistence.ManyToOne ;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Factura - creamos este objeto
 */

// Para generar objeto en base de dato usamos la siguiente etiqueta 
@Entity

public class Factura {

 // para indicar la primary key PK   
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String fecha;
    
    private Double total;

// el reciproco de la relacion uno a muchos - muchos a uno	
	@ManyToOne
	private Cliente cliente;
	
// el reciproco de la realacion muchos a muchos con factura-producto
     @ManyToMany(mappedBy = "facturas")
      private List<Producto> productos;
   


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
















































