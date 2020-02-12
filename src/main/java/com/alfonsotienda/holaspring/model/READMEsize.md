¿Cuál es la diferencia entre la verificación de validación de los siguientes tres campos?

@Entity
public class MyEntity {

    @Column(name = "MY_FIELD_1", length=13)
    private String myField1;
    @Column(name = "MY_FIELD_2")
    @Size(min = 13, max = 13)
    private String myField2;
    @Column(name = "MY_FIELD_3", nullable = false , unique = true)
    @Length(min = 13, max = 13)
    private String myField3;

    // getter & setter

}




# 1.@Columnes una anotación JPA y la length herramienta de generación de esquemas utiliza el atributo para establecer la longitud de la columna SQL asociada. Para hacerla NOT NULL- usar nullable = false.
# 2.@Size es una anotación de validación de bean que valida que la cadena asociada tiene un valor cuya longitud está limitada por los valores mínimo y máximo.
# 3.@Length es una anotación específica de Hibernate y tiene el mismo significado que @Size
# Por lo tanto 2.y 3.debe validar la String longitud usando Bean Validation. Elegiría 2.porque es genérico.