package com.elorrieta.overdress.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.overdress.modelo.Coleccion;

/**
 * Clase encargada relacionar el POJO con la Tabla DAO Data Access Object
 * 
 * @author Admin
 *
 */

public class ColeccionDAO {

	public static ArrayList<Coleccion> getAll() {

		ArrayList<Coleccion> coleccion = new ArrayList<Coleccion>();
		String sql = " SELECT id, nombre FROM coleccion ORDER BY nombre ASC; ";

		try (Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {

				Coleccion c = new Coleccion();
				c.setId(rs.getInt("id"));
				c.setNombre(rs.getString("nombre"));

				coleccion.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return coleccion;
	}
	// getAll

}
