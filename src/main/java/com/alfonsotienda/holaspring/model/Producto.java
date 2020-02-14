package  com.alfonsotienda.holaspring.model ;

import java.util.ArrayList;
import  java.util.List ;

import  javax.persistence.CascadeType ;
import  javax.persistence.Column ;
import  javax.persistence.Entity ;
import  javax.persistence.GeneratedValue ;
import  javax.persistence.GenerationType ;
import  javax.persistence.Id ;
import  javax.persistence.JoinColumn;
import  javax.persistence.JoinTable;
import  javax.persistence.ManyToOne ;
import  javax.persistence.OneToMany ;
import  javax.persistence.ManyToMany;
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
@Table(name="Producto")
public class Producto {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;
   
    @Column(name = "VALOR")
    private Integer valor;

 // tabla intermedia   
    @JoinTable(
        name = "rel_producto_factura",
        joinColumns = @JoinColumn(name = "FK_PRODUCTO", nullable = false),
        inverseJoinColumns = @JoinColumn(name="FK_FACTURA", nullable = false)
    )
    
 // relacion prducto-factura   
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Factura> facturas;
   
  
    public void addFactura(Factura factura){
        if(this.facturas == null){
            this.facturas = new ArrayList<>();
        }
        
        this.facturas.add(factura);
    }


    /** GET and SET */


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

// generamos constructor

	public Producto(String nombre, Integer valor) {
	
		this.nombre = nombre;
		this.valor = valor;
		
	}

// generamos toString
	@Override
	public String toString() {
		return "Producto [facturas=" + facturas + ", id=" + id + ", nombre=" + nombre + ", valor=" + valor + "]";
	}

    
 }  
  









