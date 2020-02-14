Relaciónes @ManyToMany

Las relaciones Mucho a Muchos (@ManyToMany) se caracterízan por Entidades que están relacionadas con a muchos elementos de un tipo determinado, pero al mismo tiempo, estos últimos registros no son exclusivos de un registro en particular, si no que pueden ser parte de varios, por lo tanto, tenemos una Entidad A, la cual puede estar relacionada como muchos registros de la Entidad B, pero al mismo tiempo, la Entidad B puede pertenecer a varias instancias de la Entidad A.

Algo muy importante a tomar en cuenta cuando trabajamos con relaciones @ManyToMany, es que en realidad este tipo de relaciones no existen físicamente en la base de datos, y en su lugar, es necesario crear una tabla intermedia que relaciones las dos Entidades.

Como podemos apreciar, hemos creado una lista de tipo Factura, la cual es anotada con @ManyToMany, adicional, hemos definido la anotación @JoinTable, la cual nos sirve para definir la estructura de la tabla intermedia que contendrá la relación entre los productos y facturas.

La anotación @JoinTable no es obligatoria en sí, ya que en caso de no definirse JPA asumirá el nombre de la tabla, columnas, longitud, etc. Para no quedar a merced de la implementación de JPA, siempre es recomendable definirla, así, tenemos el control total sobre ella.

Hemos definidos las siguientes propiedades de la anotación @JoinTable:

name: Nombre de la tabla que será creada físicamente en la base de datos.
joinColumns: Corresponde al nombre para el ID de la Entidad Producto.
inverseJoinColumns: Corresponde al nombre para el ID de la Entidad Factura
La tabla intermedia (rel_producto_factura) es generada por la anotación @JoinTable y sus dos columnas son llaves foraneas a las tablas books y authors.


El caso de la Entidad Factura es más simple, pues solo marcamos la colección con @ManyToMany, pero en este caso ya no es necesario definir la anotación @JoinTable, en su lugar, definimos la propiedad mappedBy para indicar la relación bidireccional y al mismo tiempo, JPA puede tomar la configuración del @JoinTable de Productos.

Para concluir solo faltaría resaltar que en las relaciones @ManyToMany los registros son independientes de los registros a los que son relacionados, por lo que en este caso, podrían existir los facturas si no existieran los productos, y al revés.