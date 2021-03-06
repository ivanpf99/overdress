package com.elorrieta.overdress.controladores.Backoffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.overdress.modelo.dao.CartaDAO;

/**
 * Servlet implementation class ParticpantesEliminarController
 */
@WebServlet("/backoffice/cartas-eliminar")
public class CartasEliminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		try {
			CartaDAO.delete(id);

			request.setAttribute("mensajeTipo", "warning");
			request.setAttribute("mensaje", "Carta eliminada");
		} catch (Exception e) {
			request.setAttribute("mensajeTipo", "danger");
			request.setAttribute("mensaje", "No se puede Eliminar");
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/backoffice/cartas-listar");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
