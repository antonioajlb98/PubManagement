package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import utils.Connect;

public class ClienteDAO {
	
	private static ClienteDAO _instance;
	
	public static ClienteDAO getInstance() {
		if (_instance == null) {
			_instance = new ClienteDAO();
		}
		return _instance;
	}

	private Connection miCon;

	private ClienteDAO() {
		miCon = Connect.getConnect();
	}
	
	/**
	 * Funcion que comprueba si los datos introducidos en el login
	 * son correctos o no 
	 * @param user Usuario introducido en la ventana de login 	
	 * @param contrasena Contraseña introducida en la ventana de Login 
	 * @return Devuelve true si el usuario se encuentra en la base de datos
	 * o false si no.
	 */
	public boolean login(String user, String contrasena) {
		boolean logeado = false;
		if (this.miCon != null) {
			String sql = "select * from cliente where usuario= ? and contrasena= ? ";
			try {
				PreparedStatement ps = miCon.prepareStatement(sql);
				ps.setString(1, user);
				ps.setString(2, contrasena);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					logeado=true;
				}else {
					logeado=false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Hubo un error en la ejecucion:\n"+e.getMessage());
			}
		}
		return logeado;
	}
	
	
	/**
	 * Funcion que inserta un cliente en la BBDD
	 * @param c Cliente que queremos insertar
	 * @return devuelce true si se ha introducido correctamente o 
	 * false si no
	 */
	public boolean insert(Cliente c) {
		boolean insertado = false;
		String sql = "Insert into cliente values (null,?,?,?,?)";
		try {
			PreparedStatement ps = miCon.prepareStatement(sql);
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getApellidos());
			ps.setString(3, c.getUsuario());
			ps.setString(4, c.getContrasena());
			ps.executeUpdate();
			insertado = true;
		} catch (SQLException e) {
			insertado = false;
			e.printStackTrace();
		}
		return insertado;

	}
	/**
	 * Funcion para borrar un cliente de la base de datos
	 * @param c Cliente que queremos borrar
	 * @return Devuelve true si lo ha borrado correctamente o false si no.
	 */
	public boolean delete(Cliente c) {
		boolean borrado = false;
		
		return borrado;
	}

	public boolean update(Cliente c) {
		boolean result = false;
		String consulta="UPDATE cliente SET Nombre=?, Apellidos=?, contrasena=?, usuario=? WHERE id=?";
		try {
			PreparedStatement sentencia = miCon.prepareStatement(consulta);
			sentencia.setString(2, c.getApellidos());
			sentencia.setString(1, c.getNombre());
			sentencia.setString(4, c.getUsuario());
			sentencia.setString(3, c.getContrasena());
			sentencia.setInt(5, c.getCodigo());
			sentencia.executeUpdate();
			result=true;
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		
		return result;
	}
	/**
	 * Funcion que coge un Cliente de la base de datos a traves de su usuario.
	 * @param user String pasado como parametro que sirve para identificar al cliente.
	 * @return devuelve el cliente si se encuentra en la base de datos.
	 */
	public Cliente getUser(String user) {
		Cliente c = new Cliente();
		if (this.miCon != null) {
			String sql = "select id,nombre,apellidos,usuario,contrasena from cliente where usuario= ?";
			try {
				PreparedStatement ps = miCon.prepareStatement(sql);
				ps.setString(1, user);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					c.setNombre(rs.getString(2));
					c.setApellidos(rs.getString(3));
					c.setCodigo(rs.getInt(1));
					c.setUsuario(rs.getString(4));
					c.setContrasena(rs.getString(5));
				}else {
				}
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Hubo un error en la ejecucion:\n"+e.getMessage());
			}
		}
		return c;
	}
	public Cliente getCliente(Cliente c) {
		Cliente c1 = new Cliente();
		if (this.miCon != null) {
			String sql = "select id,nombre,apellidos,usuario,contrasena from cliente where usuario= ?";
			try {
				PreparedStatement ps = miCon.prepareStatement(sql);
				ps.setString(1, c.getUsuario());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					c1.setNombre(rs.getString(2));
					c1.setApellidos(rs.getString(3));
					c1.setCodigo(rs.getInt(1));
					c1.setUsuario(rs.getString(4));
					c1.setContrasena(rs.getString(5));
				}else {
				}
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Hubo un error en la ejecucion:\n"+e.getMessage());
			}
		}
		return c1;
	}
}
