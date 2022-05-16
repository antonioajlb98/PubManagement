package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import utils.Connect;

public class ProductoDAO {
	
	private static ProductoDAO _instance;
	private ProductoDAO() {
	}
	public static ProductoDAO getInstance() {
		if (_instance == null) {
			_instance = new ProductoDAO();
		}
		return _instance;
	}

	public static Collection<Producto> getAll() {
		Collection<Producto> listaProductos = new ArrayList<Producto>();
		String sql = "select id,nombre,tipo,precio from producto";
		Connection miCon = Connect.getConnect();
		try {
			Statement st = miCon.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Producto p = new Producto();
				listaProductos.add(p);
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setTipo(rs.getString(3));
				p.setPrecio(rs.getFloat(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProductos;
	}

	public boolean insert(Producto p) {
		boolean insertado = false;
		String sql = "Insert into Producto values (null,?,?,?)";
		Connection miCon = Connect.getConnect();
		try {
			PreparedStatement ps = miCon.prepareStatement(sql);
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getTipo());
			ps.setFloat(3, p.getPrecio());
			ps.executeUpdate();
			insertado = true;
		} catch (SQLException e) {
			insertado = false;
			e.printStackTrace();
		}
		return insertado;

	}

	public boolean delete(Producto p) {
		boolean eliminado = false;
		String sql = "delete from Producto where id=?";
		Connection miCon = Connect.getConnect();
		try {
			PreparedStatement ps = miCon.prepareStatement(sql);
			ps.setInt(1,p.getId());
			ps.executeUpdate();
			eliminado = true;
		} catch (SQLException e) {
			eliminado = false;
			e.printStackTrace();			
		}
		return eliminado;
	}
}
