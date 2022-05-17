package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import utils.Connect;

public class BebidaDAO {
	
	private static BebidaDAO _instance;
	private BebidaDAO() {
	}
	public static BebidaDAO getInstance() {
		if (_instance == null) {
			_instance = new BebidaDAO();
		}
		return _instance;
	}
	
	
	public static Collection<Bebida> getAll() {
		Collection<Bebida> listaBebidas = new ArrayList<Bebida>();
		String sql = "select id,nombre,tipo,precio from producto where tipo='Bebida'";
		Connection miCon = Connect.getConnect();
		try {
			Statement st = miCon.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Bebida b = new Bebida();
				listaBebidas.add(b);
				b.setId(rs.getInt(1));
				b.setNombre(rs.getString(2));
				b.setTipo(rs.getString(3));
				b.setPrecio(rs.getFloat(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaBebidas;
	}
}
