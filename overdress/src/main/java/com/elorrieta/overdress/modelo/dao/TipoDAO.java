package com.elorrieta.overdress.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.overdress.modelo.Tipo;

/**
 * Clase encargada relacionar el POJO con la Tabla DAO Data Access Object
 * 
 * @author Admin
 *
 */

public class TipoDAO {

	public static ArrayList<Tipo> getAll() {

		ArrayList<Tipo> coleccion = new ArrayList<Tipo>();
		String sql = " SELECT id, nombre FROM tipo ORDER BY nombre ASC; ";

		try (Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {

				Tipo t = new Tipo();
				t.setId(rs.getInt("id"));
				t.setNombre(rs.getString("nombre"));

				coleccion.add(t);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return coleccion;
	}
	// getAll

}
