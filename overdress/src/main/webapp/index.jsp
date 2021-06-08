<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="plantillas/cabecera.jsp"/>
<jsp:include page="plantillas/menu.jsp"/>


	<table class="table table-hover">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Nombre</th>
	      <th scope="col">Numero_id</th>
	      <th scope="col">Coleccion</th>
	      <th scope="col">Tipo</th>
	      <th scope="col">Grado</th>
	      <th scope="col">Copias</th>
	    </tr>
	  </thead>
	  <tbody>
    		<c:forEach var="carta" items="${cartas}">
	          <tr>
	            <th scope="row">${carta.id}</th>
	            <td>${carta.nombre}</td>
	            <td>${carta.numero_id}</td>
	            <td>${carta.coleccion.nombre}</td>
	            <td>${carta.tipo.nombre}</td>
	            <td>${carta.grado.nombre}</td>
	            <td>${carta.copias}</td>
	            
	          </tr>
	      </c:forEach>
	   
	  </tbody>
	</table>

<jsp:include page="plantillas/footer.jsp"/>

