package com.elorrieta.overdress.controladores.Backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.overdress.modelo.Carta;
import com.elorrieta.overdress.modelo.dao.CartaDAO;

/**
 * Servlet implementation class ParticipantesController
 */
@WebServlet("/cartas-listar")

public class CartasListarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 1000 usuarios de prueba for

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// logica de negocio, conseguir coleccion de Carta

		ArrayList<Carta> lista = CartaDAO.getAll();

		// enviar atributos para pintar
		request.setAttribute("Cartas", lista);

		// ir a la vista
		request.getRequestDispatcher("backoffice/Cartas.jsp?page=participantes").forward(request, response);

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
