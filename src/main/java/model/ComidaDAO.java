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
	
	public static Collection<Comida> getAll() {
		Collection<Comida> listaComida = new ArrayList<Comida>();
		String sql = "select id,nombre,tipo,precio from producto where tipo=Bebida";
		Connection miCon = Connect.getConnect();
		try {
			Statement st = miCon.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Comida c = new Comida();
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
