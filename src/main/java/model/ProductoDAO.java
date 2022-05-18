package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JOptionPane;

import utils.Connect;

public class ProductoDAO {

	private static ProductoDAO _instance;

	public static ProductoDAO getInstance() {
		if (_instance == null) {
			_instance = new ProductoDAO();
		}
		return _instance;
	}

	private Connection miCon;

	private ProductoDAO() {
		miCon=Connect.getConnect();
	}
	
	public Producto getProduct(String name) {
		Producto p = new Producto();
		if (this.miCon != null) {
			String sql = "select id,nombre,Tipo,Precio from Producto where nombre=?";
			try {
				PreparedStatement ps = miCon.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					p.setNombre(rs.getString(2));
					p.setTipo(rs.getString(3));
					p.setId(rs.getInt(1));
					p.setPrecio(rs.getFloat(4));
				}else {
				}
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Hubo un error en la ejecucion:\n"+e.getMessage());
			}
		}
		return p;
	}
	public Collection<Producto> getAll() {
		Collection<Producto> listaProductos = new ArrayList<Producto>();
		String sql = "select id,nombre,tipo,precio from producto";
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
	/**
	 * Funcion que inserta un Producto en la BBDD
	 * @param p Producto que queremos insertar
	 * @return devuelce true si se ha introducido correctamente o 
	 * false si no
	 */
	public boolean insert(Producto p) {
		boolean insertado = false;
		String sql = "Insert into Producto values (null,?,?,?)";
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
	/**
	 * Funcion para borrar un Producto de la base de datos
	 * @param p Producto que queremos borrar
	 * @return Devuelve true si lo ha borrado correctamente o false si no.
	 */
	public boolean delete(Producto p) {
		boolean eliminado = false;
		String sql = "delete from Producto where id=?";
		try {
			PreparedStatement ps = miCon.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.executeUpdate();
			eliminado = true;
		} catch (SQLException e) {
			eliminado = false;
			e.printStackTrace();
		}
		return eliminado;
	}
	/**
	 * Funcion para modificar parametros de un producto y que se actualicen en la 
	 * bsae de datos
	 * @param p producto que queremos actualizar
	 * @return devuelve true si se ha actualizado correctamente o false si no.
	 */
	public boolean update(Producto p) {
		boolean result = false;
		String consulta = "UPDATE producto SET Nombre=?, Precio=?, Tipo=? WHERE id=?";
		try {
			PreparedStatement sentencia = miCon.prepareStatement(consulta);
			sentencia.setFloat(2, p.getPrecio());
			sentencia.setString(1, p.getNombre());
			sentencia.setInt(4, p.getId());
			sentencia.setString(3, p.getTipo());
			sentencia.executeUpdate();
			result = true;
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}

		return result;
	}
	
	public Collection<Producto> getAllBebidas() {
		Collection<Producto> listaProductos = new ArrayList<Producto>();
		String sql = "select id,nombre,tipo,precio from producto where Tipo='Bebida'";
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
	
	public Collection<Producto> getAllComida() {
		Collection<Producto> listaProductos = new ArrayList<Producto>();
		String sql = "select id,nombre,tipo,precio from producto where Tipo='Comida'";
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
}
