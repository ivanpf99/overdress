# overdress

Proyecto Web **Java EE** siguiendo el patrón de **MVC** contra una bbdd **sqllite**
CMS para gestionar diferntes tablas. 


![screenshot 1]( screenshot1.jpg?raw=true)


## Técnologia

- Maven 4.0.0
- Java 8
- Java Servlet Api 3.1.0
- JSP 2.2
- JSTL 1.2
- Bootstrap 5.0.0
- FontAwesome 5.15.3


Para ver mas detalles sobre las depencias de este proyecto mirar el [pom.xml](https://github.com/ivanpf99/overdress/blob/master/overdress/pom.xml)




## configuración de la bbdd

Para crear la bbdd disponemos de un script **script-db.sql** en la raiz del proyecto, el cual crear el esquema **supermercado** y las tablas necesarias, ademas de insertar datos de prueba.

![screenshot 2]( screenshot2.jpg?raw=true)

Para realizar la conexión a la bbdd cambiar el siguiente fichero **src\main\java\com\elorrieta\overdress\modelo\dao\ConnectionHelper.java**
debemos cambiar la siguiente variable con la ruta de la bbdd

```
private static final String DIRECCION_BBDD = "jdbc:sqlite:C:\\desarrolloJava\\workspace\\overdress\\Overdress.db";
```


 -- TODO DIAGRAMA DE LA BBDD  ---

## Ejecutar Proyecto

Al ser un proyecto web necesitamos un servidor de aplicaciones, en nuestro caso recomendamos **Apache Tomcat 8.5**.

Podemos navegar por los diferentes enlaces de la cabecera puesto que son públicos.
Si queremos entrar a los paneles de Administración deberemos *Iniciar Sesión*.


1. Administrador   **[admin,admin]** : Permisos Totales para cambiar cualquier carta
2. 

*UI para usuario administrador con rol = 2.*


## Estructura Clases del proyecto

Interesante consultar la documentacion [JavaDoc API](https://github.com/ipartek/supermercado-java/tree/master/src/main/webapp/doc) la cual esta accesible una vez ejecuitado el proyecto en la propia barra de navegación.

Intersante mirar los siguientes packages de java:

- **com.ipartek.formacion.listenner** Listener que se ejecuta al arrancar la APP
- **com.ipartek.formacion.controller.backoffice** Controladores para el usuario administrador
- **com.ipartek.formacion.controller.frontoffice** Controladores para el usuario normal
- **com.ipartek.formacion.modelo.pojo** Pojos o Clases para crear Objetos e java
- **com.ipartek.formacion.modelo.dao** DAO para relacionar los Pojos de Java con las tablas dela BBDD
- **com.ipartek.formacion.seguridad** Filtros de seguridad