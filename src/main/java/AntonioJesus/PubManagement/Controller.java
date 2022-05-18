package AntonioJesus.PubManagement;

import java.util.ArrayList;

import model.Cliente;
import model.ClienteDAO;
import model.PedidoDAO;
import model.Producto;
import model.ProductoDAO;
import utils.Utils;

public class Controller {
	protected static Cliente usuariologeado;
	protected static ArrayList<Producto> nuevoPedido = new ArrayList<Producto>();
	protected PedidoDAO pedidoDAO;
	protected ProductoDAO pDAO;
	protected ClienteDAO cDAO;
	protected Utils u;
	public Controller() {
		pedidoDAO = PedidoDAO.getInstance();
		pDAO = ProductoDAO.getInstance();
		cDAO = ClienteDAO.getInstance();
		u = new Utils();
	}
}
