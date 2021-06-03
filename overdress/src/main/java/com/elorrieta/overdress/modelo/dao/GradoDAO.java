package com.elorrieta.overdress.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.overdress.modelo.Grado;

/**
 * Clase encargada relacionar el POJO con la Tabla DAO Data Access Object
 * 
 * @author Admin
 *
 */

public class GradoDAO {

	public static ArrayList<Grado> getAll() {

		ArrayList<Grado> coleccion = new ArrayList<Grado>();
		String sql = " SELECT id, nombre FROM grado ORDER BY nombre ASC; ";

		try (Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {

				Grado g = new Grado();
				g.setId(rs.getInt("id"));
				g.setNombre(rs.getString("nombre"));

				coleccion.add(g);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return coleccion;
	}
	// getAll

}
