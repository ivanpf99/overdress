package com.elorrieta.overdress.controladores.Backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.overdress.modelo.Usuario;
import com.elorrieta.overdress.modelo.dao.UsuarioDAO;

/**
 * Servlet implementation class ParticipantesController
 */
@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recoger parametros, no tenemos

		// logica de negocio, conseguir coleccion de Participantes

		ArrayList<Usuario> usuarios = UsuarioDAO.getAll();

		// enviar atributos para pintar
		request.setAttribute("usuarios", usuarios);

		// ir a la vista
		request.getRequestDispatcher("usuarios.jsp?page=usuarios").forward(request, response);

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
