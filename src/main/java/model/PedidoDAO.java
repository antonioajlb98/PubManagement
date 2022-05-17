package model;

public class PedidoDAO {
	
	private static PedidoDAO _instance;
	private PedidoDAO() {
	}
	public static PedidoDAO getInstance() {
		if (_instance == null) {
			_instance = new PedidoDAO();
		}
		return _instance;
	}
	
	
}
