package AntonioJesus.PubManagement;

import java.util.ArrayList;

import model.BebidaDAO;
import model.Cliente;
import model.ClienteDAO;
import model.ComidaDAO;
import model.PedidoDAO;
import model.Producto;
import model.ProductoDAO;
import utils.Utils;

public class Controller {
	protected static Cliente usuariologeado;
	protected static ArrayList<Producto> nuevoPedido;
	protected PedidoDAO pedidoDAO;
	protected ProductoDAO pDAO;
	protected ClienteDAO cDAO;
	protected BebidaDAO bebidaDAO;
	protected ComidaDAO comidaDAO;
	protected Utils u;
	public Controller() {
		pedidoDAO = PedidoDAO.getInstance();
		pDAO = ProductoDAO.getInstance();
		cDAO = ClienteDAO.getInstance();
		bebidaDAO = BebidaDAO.getInstance();
		comidaDAO = ComidaDAO.getInstance();
		u = new Utils();
		nuevoPedido = new ArrayList<Producto>();
	}
}
