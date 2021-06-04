<jsp:include page="plantillas/cabecera.jsp"/>
<jsp:include page="plantillas/menu.jsp"/>


${cartas}


<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Numero_id</th>
      <th scope="col">Nombre</th>
      <th scope="col">Coleccion</th>
      <th scope="col">Tipo</th>
      <th scope="col">Grado</th>
      <th scope="col">Copiasth>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="cIteracion" items="${cartas}">
	          <tr>
	            <th scope="row">${cIteracion.id}</th>
	            <td>${cIteracion.numero_id}</td>
	            <td>${cIteracion.nombre}</td>
	            <td>${cIteracion.coleccion}</td>
	            <td>${cIteracion.tipo}</td>
	            <td>${cIteracion.grado}</td>
	            <td>${cIteracion.copias}</td>
	          </tr>
	         </c:forEach>
   
  </tbody>
</table>

<jsp:include page="plantillas/footer.jsp"/>

