Strategy-  tipos

Anotación @GeneratedValue
A estas alturas probablemente te preguntaras como sabe si el ID es autogenerado (Identity) como en el caso de MySQL y MS SQL Server, o si es calculado a través de una secuencia como en el caso de Oracle y Postgres. Pues bien, JPA cuenta con la anotación @GeneratedValue para indicarle a JPA que regla de autogeneración de la lleve primaria vamos a utilizar.

JPA soporta 4 estrategias de autogeneración de la llave primaria, las cuales se describen a continuación:

# Identity:
Esta estrategia es la más fácil de utilizar pues solo hay que indicarle la estrategia y listo, no requiere nada más, JPA cuando persista la entidad no enviará este valor, pues asumirá que la columna es auto generada. Esto provoca que el contador de la columna incremente en 1 cada vez que un nuevo objeto es insertado. Veamos cómo quedaría la clase Employee con esta estrategia.

ackage com.obb.jpa.jpaturorial.entity;

import javax.persistence.*;

/**
 * strategy IDENTITY
 */
@Entity
@Table(
    name = "EMPLOYEES" , 
    schema = "jpatutorial", 
    indexes = {@Index(name = "name_index", columnList = "name",unique = true)}
)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; 
}


# Sequence
Mediante esta estrategia le indicamos a JPA que el ID de generar a través de una secuencia de la base de datos. De esta manera, cuando se realice un insert, esta agregara la instrucción para que en el ID se inserte el siguiente valor de la secuencia.

* Anotación @SequenceGenerator 
Esta anotación se define por lo general a nivel de clase, y es utiliza para indicarle a JPA que secuencia debe de utilizar para insertar en la base de datos.

Veamos cómo quedaría la clase Empleado con esta estrategia:

package com.obb.jpa.jpaturorial.entity;

import javax.persistence.*;

/**
 * strategy SEQUENCE
 */
@Entity
@Table(
    name = "EMPLOYEES" , 
    schema = "jpatutorial", 
    indexes = {@Index(name = "name_index", columnList = "name",unique = true)}
)
@SequenceGenerator(
    name="EmployeeSeq",
    sequenceName = "EMPLOYEES_SEQ",
    initialValue = 1, 
    allocationSize = 10
)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EmployeeSeq")
    private Long id;
    private String name; 
}

La anotación @SequenceGenerator tiene las siguientes propiedades:

# name: nombre con el que se identifica la secuencia en JPA, este nombre no corresponde al nombre real de la secuencia en la base de datos y debe de coincidir con la propiedad generator  de la anotación @GeneratorValue
# sequenceName: nombre real de la secuencia en la base de datos
# initialValue: valor inicial de la secuencia, solo en caso de que JPA la cree
# allocationSize: incremento de la secuencia, solo en caso de que JPA la cree


# Table
Esta es una estrategia especial de JPA, la cual no depende de la base de datos utilizada como es el caso de Sequence e Identity, puesta esta estrategia crea una tabla únicamente para controlar una secuencia autogenerada por Entidad. Puede resultar confuso, pero en realidad lo que hace esta estrategia es simular la estrategia Identity creando una tabla con dos columnas, la primera el nombre de la entidad y la segunda el último ID utilizado, de esta forma, cuando un nuevo objeto es insertado consulta el último ID de esa entidad, lo incrementa y lo asigna a la nueva entidad al mismo tiempo que actualiza la tabla con el último ID utilizado.

Esta estrategia es utilizada más que nada por su portabilidad, pero siempre es mejor utilizar las estrategias nativas de la base de datos como secuencias e identity pues suelen tener un mejor rendimiento.

 

* Anotación @TableGenerator
Al igual que la estrategia sequence, es necesario indicarle a JPA que tabla se va a utilizar para guardar las secuencias por Entidad.

Veamos cómo quedaría la clase Empleado con esta estrategia:

package com.obb.jpa.jpaturorial.entity;

import javax.persistence.*;

/**
 * strategy TABLE
 */
@Entity
@Table(
    name = "EMPLOYEES" , 
    schema = "jpatutorial", 
    indexes = {@Index(name = "name_index", columnList = "name",unique = true)}
)
@TableGenerator(
    name = "EmployeeTable", 
    initialValue = 1, 
    pkColumnName = "ENTITY", 
    pkColumnValue = "ID", 
    allocationSize = 10, 
    table = "ENTITY_GENERATOR"
)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "EmployeeTable")
    private Long id;
    private String name;

* La anotación @TableGenerator tiene las siguientes propiedades:

# name: nombre con el que se identifica la tabla en JPA, este nombre no corresponde al nombre real de la tabla en la base de datos y debe de coincidir con la propiedad generator  de la anotación @GeneratorValue
# table: nombre real de la tabla en la base de datos
# pkColumnName: nombre real de la columna en la que se guardará el nombre de la sequencia
# pkColumnValue: nombre real de la columna en la que se guardara el último ID generado
# initialValue: valor con el que se iniciara la secuencia
# allocationSize: incremento de la secuencia

# Auto:
Finalmente, esta estrategia lo único que hace es decirle a JPA que utilice la estrategia por default para la base de datos con la que estamos trabajando. En lo particular es la que menos recomiendo pues dejamos la estrategia a interpretación de JPA y esto nos puedo dejar muchos dolores de cabeza.

 

* NOTA: En el caso de no declarar la anotación @GeneratedValue, JPA asumirá que no hay una estrategia de autogeneración, por lo que será necesario establecer el ID manualmente antes de persistir la entidad.

 

* Estrategia a utilizar
A lo largo de este tutorial estaremos trabajando con MySQL debido a que es la base de datos más popular y libre de licencia, por esta razón hemos decidido que la estrategia a utilizar a lo largo de este tutorial será IDENTITY. Claro que tú eres libre de trabajar con otra base de datos y una estrategia distinta, si es que sientes mas cómodo