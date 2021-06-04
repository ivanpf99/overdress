<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="plantillas/cabecera.jsp"/>
<jsp:include page="plantillas/menu.jsp"/>

<main class="container">
    <h1>Listado Usuarios</h1>
    <a href="usuario.html">Nuevo Usuario</a>
    
    <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">id</th>
            <th scope="col">Nombre</th>
            <th scope="col">pass</th>
            <th scope="col">Rol</th>
          </tr>
        </thead>
        <tbody>
        <!-- 
        	recorrer atributo con la lista de particpantes y pintar TR
        	items="$ { participantes}" => Nombre del atributo que nos envia en controlador
        	var="pIteracion"           => nombre de la variable que iteramos que es un Participante 
        
        	${p.nombre} es lo mismo que p.getNombre(), es una forma abreviada
        
        -->
        
        <c:forEach var="uIteracion" items="${usuarios}">
	          <tr>
	            <th scope="row">${uIteracion.id}</th>
	            <td>${uIteracion.id}</td>
	            <td>${uIteracion.nombre}</td>
	            <td>${uIteracion.pass}</td>
	            <td>${uIteracion.rol}</td>
	          </tr>
	         </c:forEach> 
	         <!-- terminamos de recorrer -->
        </tbody>
      </table>
        
</main> 

<jsp:include page="plantillas/footer.jsp"/>