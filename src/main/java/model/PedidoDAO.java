package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import utils.Connect;

public class PedidoDAO {
	
	private static PedidoDAO _instance;
	private Connection miCon;
	
	
	
	private PedidoDAO() {
		miCon = Connect.getConnect();
	}
	public static PedidoDAO getInstance() {
		if (_instance == null) {
			_instance = new PedidoDAO();
		}
		return _instance;
	}
	
	
	/**
	 * Funcion que coge un Pedido de la base de datos a traves de su codCliente.
	 * @param codCliente String pasado como parametro que sirve para identificar al Pedido.
	 * @return devuelve el cliente si se encuentra en la base de datos.
	 */
	public Pedido getPedido(int codCliente) {
		Pedido p = new Pedido();
		if (this.miCon != null) {
			String sql = "select cod_Pedido,cod_Cliente from Pedido where cod_Cliente=?";
			try {
				PreparedStatement ps = miCon.prepareStatement(sql);
				ps.setInt(1, codCliente);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					p.setCod_cliente(rs.getInt(2));
					p.setCod_Pedido(rs.getInt(1));
				}else {
				}
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Hubo un error en la ejecucion:\n"+e.getMessage());
			}
		}
		return p;
	}
	/**
	 * Funcion que inserta un cliente en la BBDD
	 * @param p Pedido que queremos insertar
	 * @return devuelve true si se ha introducido correctamente o 
	 * false si no
	 */
	public boolean insert(Pedido p) {
		boolean insertado = false;
		String sql = "Insert into Pedido values (?,null)";
		try {
			PreparedStatement ps = miCon.prepareStatement(sql);
			ps.setInt(1, p.getCod_cliente());
			ps.executeUpdate();
			insertado = true;
		} catch (SQLException e) {
			insertado = false;
			e.printStackTrace();
		}
		return insertado;

	}
	
}
