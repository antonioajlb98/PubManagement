package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import utils.Connect;

public class ComidaDAO {
	
	private static ComidaDAO _instance;
	private ComidaDAO() {
	}
	public static ComidaDAO getInstance() {
		if (_instance == null) {
			_instance = new ComidaDAO();
		}
		return _instance;
	}
	/**
	 * Funcion que Coge todos los elementos de la base de datos 
	 * y los mete en un ArrayList
	 * @return Devuelve el ArrayList con los Datos.
	 */
	public static Collection<Producto> getAll() {
		Collection<Producto> listaComida = new ArrayList<Producto>();
		String sql = "select id,nombre,tipo,precio from producto where tipo='Comida'";
		Connection miCon = Connect.getConnect();
		try {
			Statement st = miCon.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Producto c = new Producto();
				listaComida.add(c);
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setTipo(rs.getString(3));
				c.setPrecio(rs.getFloat(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaComida;
	}
}
