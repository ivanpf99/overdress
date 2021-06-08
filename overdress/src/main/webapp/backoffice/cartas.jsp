<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"  %>

<jsp:include page="../plantillas/cabecera.jsp"/>
<jsp:include page="../plantillas/menu.jsp"/>



 <main class="container">
    <h1>Listado Cartas</h1>
    <a href="backoffice/cartas-editar?id=0">Nueva carta</a>
    
    <form action="backoffice/cartas-listar" method="get">
	    <div class="input-group">
		  <div class="form-outline">
		    <input type="search" name="filtro"
		           value="${filtro}" 
		           class="form-control"		           
		           placeholder="Nombre, grado o email"/>	    
		  </div>
		  <button type="submit" class="btn btn-primary">
		    <i class="fas fa-search"></i>
		  </button>
		</div>
	</form>
    
    
    <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Numero_id</th>
            <th scope="col">Nombre</th>
            <th scope="col">Coleccion</th>
            <th scope="col">Tipo</th>
            <th scope="col">Grado</th>
            <th scope="col">Copias</th>
             <th scope="col">Editar</th>
            <th scope="col">Eliminar</th>
          </tr>
        </thead>
        <tbody>
        <!-- 
        	recorrer atributo con la lista de particpantes y pintar TR
        	items="$ { participantes}" => Nombre del atributo que nos envia en controlador
        	var="pIteracion"           => nombre de la variable que iteramos que es un Participante 
        
        	${p.nombre} es lo mismo que p.getNombre(), es una forma abreviada
        
        -->
        
	        <c:forEach var="cIteracion" items="${cartas}">
	          <tr>
	            <th scope="row">${cIteracion.id}</th>
	            <td>${cIteracion.numero_id}</td>
	            <td>${cIteracion.nombre}</td>
	            <td>${cIteracion.coleccion.nombre}</td>
	            <td>${cIteracion.tipo.nombre}</td>
	            <td>${cIteracion.grado.nombre}</td>
	            <td>${cIteracion.copias}</td>
	            <td><a href="backoffice/cartas-editar?id=${cIteracion.id}" class="btn btn-outline-primary">Editar</a></td>
	            <td><a onclick="confirmarEliminacion('${cIteracion.nombre}')" class="btn btn-outline-danger" href="backoffice/cartas-eliminar?id=${cIteracion.id}">Eliminar</a></td>
	          </tr>
	         </c:forEach> 
	         
        <!-- terminamos de recorrer -->
        </tbody>
      </table>
      
       <script>
      	
      	function confirmarEliminacion(nombre){
      		
      		if ( window.confirm("¿ Quieres Eliminar a " + nombre + " ?") ){
      			console.debug('eliminamos');
      		}else {
      			event.preventDefault(); // prevenir que el ancla haga su funcion
      			console.debug('No Eliminamos');
      		}
      		
      	}
      
      </script>
        
</main> 

<jsp:include page="../plantillas/footer.jsp"/>