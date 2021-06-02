package com.elorrieta.overdress.controladores.Backoffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParticipantesEditar
 */
@WebServlet("/cartas-editar")
public class CartasEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Carta c = new Carta();
		String titulo = "Crear Nueva carta";

		if (id > 0) {
			titulo = "Modificar Carta";
			c = CartaDAO.getById(id);
		}

		request.setAttribute("titulo", titulo);
		request.setAttribute("carta", c);
		request.getRequestDispatcher("formulario.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recoger parametro del formulario
		int id = Integer.parseInt(request.getParameter("id"));
		String numero_id = request.getParameter("numero_id");
		String nombre = request.getParameter("nombre");
		String coleccion = request.getParameter("coleccion");
		String tipo = request.getParameter("tipo");
		int grado = Integer.parseInt(request.getParameter("grado"));
		int copias = Integer.parseInt(request.getParameter("copias"));

		// creamos POJO de Participante con los datos del formulario
		Carta c = new Carta();
		c.setId(id);
		c.setNumero_id(numero_id);
		c.setNombre(nombre);
		c.setColeccion(coleccion);
		c.setTipo(tipo);
		c.setGrado(grado);
		c.setCopias(copias);

		try {
			if (id == 0) {
				CartaDAO.insert(c);
			} else {
				CartaDAO.update(c);
			}

			request.setAttribute("mensajeTipo", "primary");
			request.setAttribute("mensaje", "Datos Guardados");

		} catch (Exception e) {
			request.setAttribute("mensajeTipo", "danger");
			request.setAttribute("mensaje", "El Numero de id esta repetido");

		}

		request.setAttribute("titulo", "Modificar Carta");
		request.setAttribute("carta", c);
		request.getRequestDispatcher("formulario.jsp").forward(request, response);

	}

}
