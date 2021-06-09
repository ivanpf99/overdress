<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"  %>

<jsp:include page="../plantillas/cabecera.jsp"/>
<jsp:include page="../plantillas/menu.jsp"/>

 <main class="container">
 
    <h1>${titulo}</h1>
    <form action="backoffice/cartas-editar" method="post" class="w-50">
    
			<p class="text-warning">ID esta oculto</p>
            <input type="text" 
                   name="id"                   
                   id="id"
                   value="${carta.id}"
                   required            
                   readonly       
                   class="form-control">
                   
                   <label for="numero_id" class="form-label">Numero.id:</label>
            <input type="text" 
                   name="numeroId"                   
                   id="nombre"
                   value="${carta.numero_id}"
                   required 
                   autofocus 
                   class="form-control" 
                   placeholder="numero_id">

            <label for="nombre" class="form-label">Nombre:</label>
            <input type="text" 
                   name="nombre"                   
                   id="nombre"
                   value="${carta.nombre}"
                   required 
                   autofocus 
                   class="form-control" 
                   placeholder="Nombre">

            <label for="coleccion" class="form-label">Coleccion:</label>
            <input type="text" 
                    name="coleccion" 
                    id="coleccion"
                    value="${carta.coleccion.id}"
                    required                      
                    class="form-control" 
                    placeholder="escribe la coleccion">

            
            
            TIPOID: ${carta.tipo.id}
            <label for="tipo" class="form-label">Tipo:</label>
            <select name="tipo"  class="form-select">
            	<c:forEach items="${tipos}" var="t">
            		<option value="${t.id}"  ${ ( t.id == carta.tipo.id ) ? "selected" : "" }  >${t.nombre}</option>
            	</c:forEach>
            </select>        
                   
                    
            <label for="grado" class="form-label">Grado:</label>
            <input type="text" 
                    name="grado"
                    id="grado" 
                    value="${carta.grado.id}"
                    required                      
                    class="form-control" 
                    placeholder="seleccione grado"> 
                    
                    <label for="copias" class="form-label">Copias:</label>
            <input type="text" 
                    name="copias"
                    id="copias" 
                    value="${carta.copias}"
                    required                      
                    class="form-control" 
                    placeholder="numero de copias">       
                          

            <input type="submit" value="${ ( cartas.id == 0 ) ? 'Crear' : 'Editar' }" class="btn btn-block btn-primary mt-4">
        </form>

</main>  

<jsp:include page="../plantillas/footer.jsp"/>