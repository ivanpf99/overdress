package com.elorrieta.overdress.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.overdress.modelo.Usuario;

public class UsuarioDAO {

	/**
	 * Busca en la bbdd el usuario por su nombre y password
	 * 
	 * @param nombre   String nombre del usuario
	 * @param password String con su contraseña
	 * @return usuario con datos si existe, null su no existe
	 */

	public static ArrayList<Usuario> getAll() {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT id, nombre, pass, Rol FROM Usuarios ; ";

		try (

				Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery(); // lanza la consulta SQL y obtiene Resultados RS

		) {

			while (rs.next()) { // itero sobre los resultados de la consulta SQL

				// creamos un nuevo Objeto y lo seteamos con los valores del RS
				Usuario u = new Usuario();

				// cogemos los valres de las columnas
				int colId = rs.getInt("id");
				String colNombre = rs.getString("nombre");
				String colPass = rs.getString("pass");
				int colRol = rs.getInt("rol");

				u.setId(colId);
				u.setNombre(colNombre);
				u.setPass(colPass);
				u.setRol(colRol);

				// añadir objeto al ArrayList
				usuarios.add(u);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	public static Usuario login(String nombre, String password) {

		Usuario usuario = null;
		String sql = "SELECT id, nombre, pass, rol FROM usuario WHERE nombre = ? AND pass = ? ;";

		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			// sustituir ? por parametros de la funcion
			pst.setString(1, nombre);
			pst.setString(2, password);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					// Hemos encontrado el Usuario por su nombre y password

					// recoger valores de las columnas
					int colId = rs.getInt("id");
					String colNombre = rs.getString("nombre");
					String colPass = rs.getString("pass");
					int colRol = rs.getInt("rol");

					// crear y setear usuario
					usuario = new Usuario();
					usuario.setId(colId);
					usuario.setNombre(colNombre);
					usuario.setPass(colPass);
					usuario.setRol(colRol);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}

}
