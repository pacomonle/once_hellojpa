paquete  com.alfonsotienda.holaspring.model ;

import  java.util.List ;

import  javax.persistence.CascadeType ;
import  javax.persistence.Column ;
import  javax.persistence.Entity ;
import  javax.persistence.GeneratedValue ;
import  javax.persistence.GenerationType ;
import  javax.persistence.Id ;
import  javax.persistence.ManyToOne ;
import  javax.persistence.OneToMany ;
import  javax.persistence.Table ;
import  javax.validation.constraints.Max ;
import  javax.validation.constraints.Min ;
import  javax.validation.constraints.NotNull ;
import  javax.validation.constraints.Size ;


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
   
	@Size(min = 1, max = 40)
	private String apellido;
	
	// limites para numeros en este caso es facturacion pero podria ser edad por ejemplo
	@Min(value=18)  
	@Max(value=70)
    private Integer edad;

 // realacion uno a muchos 
 @OneToMany(mappedBy = "cliente")
 private List<Factura> facturas;


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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
      

    public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }


	
	public Cliente( String nombre, String apellido, Integer edad) {	
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	
// generar constructor boton derecho sourcer action - generar y seleccionar todo
  
// como hemos generado el id auto_increment no seria necesario incluirlo en el constructor 
	
@Override
public String toString() {
	return "Cliente [apellido=" + apellido + ", edad=" + edad + ", id=" + id + ", nombre=" + nombre + "]";
}



    
}









































