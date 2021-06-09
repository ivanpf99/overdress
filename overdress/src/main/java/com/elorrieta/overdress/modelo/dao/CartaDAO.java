package com.elorrieta.overdress.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.elorrieta.overdress.modelo.Carta;
import com.elorrieta.overdress.modelo.Coleccion;
import com.elorrieta.overdress.modelo.Grado;
import com.elorrieta.overdress.modelo.Tipo;

/**
 * Clase encargada relacionar el POJO con la Tabla DAO Data Access Object
 * 
 * @author Admin
 *
 */

public class CartaDAO {

	private static final String SQL_JOIN = "SELECT \r\n"
			+ " cartas.id, cartas.nombre, numero_id, coleccion.nombre as 'coleccion', coleccion.id as id_coleccion, tipo.nombre as 'tipo', tipo.id as id_tipo, grado.nombre as 'grado', grado.id as id_grado, cartas.copias \r\n"
			+ "				 FROM cartas INNER JOIN coleccion ON cartas.id_coleccion = coleccion.id \r\n"
			+ "				 LEFT JOIN tipo ON cartas.id_tipo = tipo.id \r\n"
			+ "				 INNER JOIN grado ON cartas.id_grado = grado.id \r\n";

	/**
	 * Consulta la tabla 'carta' para recuperar todos y devolverlos en una coleccion
	 * 
	 * @return Lista con todos las cartas de la bbdd
	 * @throws Exception
	 */
	public static ArrayList<Carta> getAll() {

		ArrayList<Carta> lista = new ArrayList<Carta>();
		String sql = SQL_JOIN + " ORDER BY cartas.nombre ASC;";

		System.out.println(sql);
		try (

				Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery(); // lanza la consulta SQL y obtiene Resultados RS

		) {

			while (rs.next()) { // itero sobre los resultados de la consulta SQL

				Carta c = mapper(rs);
				// a�adir objeto al ArrayList
				lista.add(c);

			}
			// fin del bucle, ya no quedan mas lineas para leer

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	/**
	 * Inserta una carta en la base de datos
	 * 
	 * @param cNuevo Carta a insertar
	 * @return true si es insertada, false en caso contrario
	 */
	public static boolean insert(Carta cNuevo) throws Exception {

		boolean resultado = false;
		String sql = "INSERT INTO cartas ( numero_id, nombre, id_coleccion, id_tipo, id_grado, copias ) VALUES (?,?,?,?,?,?);";

		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			// sustituir ? por valores del cNuevo
			pst.setString(1, cNuevo.getNumero_id());
			pst.setString(2, cNuevo.getNombre());
			pst.setInt(3, cNuevo.getColeccion().getId());
			pst.setInt(4, cNuevo.getTipo().getId());
			pst.setInt(5, cNuevo.getGrado().getId());
			pst.setInt(6, cNuevo.getCopias());

			// ejecuta la INSERT
			int affectedRows = pst.executeUpdate();
			// comprobamos que se ha insertado una fila
			if (affectedRows == 1) {
				resultado = true;
			}
		}

		return resultado;
	}

	/**
	 * Elimina una carta por su identificador
	 * 
	 * @param id int identificador
	 * @return true si elimina, false en caso contrario
	 * @throws Exception no deberia lanzar
	 */
	public static boolean delete(int id) throws Exception {

		boolean eliminado = false;
		String sql = "DELETE FROM cartas WHERE id = ?;";
		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, id);
			if (pst.executeUpdate() == 1) {
				eliminado = true;
			}

		}
		return eliminado;
	}

	/**
	 * Modifica una carta
	 * 
	 * @param c carta con los datos a modificar, importante que tenga un id
	 * @return true si modifica, false en caso contrario
	 * @throws Exception si el email ya existe en la tabla
	 */
	public static boolean update(Carta c) throws Exception {
		boolean modificado = false;
		String sql = "UPDATE cartas SET numero_id = ? ,nombre = ?, id_coleccion = ?, id_tipo = ?, id_grado = ?, copias = ?	WHERE id = ?;";
		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, c.getNumero_id());
			pst.setString(2, c.getNombre());
			pst.setInt(3, c.getColeccion().getId());
			pst.setInt(4, c.getTipo().getId());
			pst.setInt(5, c.getGrado().getId());
			pst.setInt(6, c.getCopias());
			pst.setInt(7, c.getId());

			System.out.println(pst);

			if (pst.executeUpdate() == 1) {
				modificado = true;
			}

		}

		return modificado;
	}

	/**
	 * Buscamos Una carta por su identificador
	 * 
	 * @param id int identificador del participantes
	 * @return Participante con datos si encuentra, NULL si no lo encuentra
	 */
	public static Carta getById(int id) {

		Carta c = new Carta();
		String sql = SQL_JOIN + " WHERE id = ?; ";

		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) { // hemos encontrado Participante por su ID

					c = mapper(rs);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	private static Carta mapper(ResultSet rs) throws SQLException {
		// creamos un nuevo Objeto y lo seteamos con los valores del RS
		Carta c = new Carta();

		// cogemos los valres de las columnas
		int colId = rs.getInt("id");
		String colNombre = rs.getString("nombre");
		String colNumero_id = rs.getString("numero_id");
		String colColeccion = rs.getString("coleccion");
		int colColeccionId = rs.getInt("id_coleccion");

		String colTipo = rs.getString("tipo");
		int colTipoId = rs.getInt("id_tipo");
		String colGrado = rs.getString("grado");
		int colGradoId = rs.getInt("id_grado");

		int colCopias = rs.getInt("copias");

		c.setId(colId);
		c.setNumero_id(colNumero_id);
		c.setNombre(colNombre);
		c.setCopias(colCopias);

		Coleccion coleccion = new Coleccion();
		coleccion.setId(colColeccionId);
		coleccion.setNombre(colColeccion);
		c.setColeccion(coleccion);

		Tipo tipo = new Tipo();
		tipo.setId(colTipoId);
		tipo.setNombre(colTipo);
		c.setTipo(tipo);

		Grado grado = new Grado();
		grado.setId(colGradoId);
		grado.setNombre(colGrado);
		c.setGrado(grado);

		return c;
	}

}
