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
		this.miCon = Connect.getConnect();
	}

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

	public boolean delete(Cliente c) {
		boolean borrado = false;
		
		return borrado;
	}

	public void update(Cliente c) {
		
	}
	public Cliente getLogeado(String user) {
		Cliente c = new Cliente();
		if (this.miCon != null) {
			String sql = "select id,nombre,apellidos,usuario from cliente where usuario= ?";
			try {
				PreparedStatement ps = miCon.prepareStatement(sql);
				ps.setString(1, user);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					c.setNombre(rs.getString(2));
					c.setApellidos(rs.getString(3));
					c.setCodigo(rs.getInt(1));
					c.setUsuario(rs.getString(4));
				}else {
				}
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Hubo un error en la ejecucion:\n"+e.getMessage());
			}
		}
		return c;
	}
}
