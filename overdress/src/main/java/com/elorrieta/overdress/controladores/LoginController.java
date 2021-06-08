package com.elorrieta.overdress.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.overdress.modelo.Usuario;
import com.elorrieta.overdress.modelo.dao.UsuarioDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mensaje = "";
		String vista = "";

		// recoger parametros
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("contraseina");

		// logica de negocio
		Usuario usuario = UsuarioDAO.login(nombre, pass);

		if (usuario != null) {
			mensaje = "Ongi Etorri";
			vista = "cartas-listar"; // nombre del controlador, no quiero ir a la JSP

			// guardar el usuario en session para el filtro
			HttpSession session = request.getSession();
			session.setAttribute("usuario_logeado", usuario);

		} else {
			mensaje = "Credenciales incorrectas, prueba de nuevo";
			vista = "login.jsp?page=login";
		}

		// enviar atributos para vistar
		request.setAttribute("mensaje", mensaje);

		// Ir a una vista
		// request.getRequestDispatcher(vista).forward(request, response);

		response.sendRedirect(request.getContextPath() + "/" + vista);

	}
}