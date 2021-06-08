package com.elorrieta.overdress.controladores.Backoffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.overdress.modelo.Carta;
import com.elorrieta.overdress.modelo.Coleccion;
import com.elorrieta.overdress.modelo.Grado;
import com.elorrieta.overdress.modelo.Tipo;
import com.elorrieta.overdress.modelo.dao.CartaDAO;

/**
 * Servlet implementation class ParticipantesEditar
 */
@WebServlet("/backoffice/cartas-editar")
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
		int idcoleccion = Integer.parseInt("idcoleccion");
		int idtipo = Integer.parseInt("idtipo");
		int idgrado = Integer.parseInt(request.getParameter("idgrado"));
		int copias = Integer.parseInt(request.getParameter("copias"));

		// creamos POJO de Carta con los datos del formulario
		Carta c = new Carta();
		c.setId(id);
		c.setNumero_id(numero_id);
		c.setNombre(nombre);

		// Coleccion
		Coleccion cole = new Coleccion();
		cole.setId(idcoleccion);
		c.setColeccion(cole);

		Tipo tipo = new Tipo();
		tipo.setId(idtipo);
		c.setTipo(tipo);

		Grado grado = new Grado();
		grado.setId(idgrado);
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
