package AntonioJesus.PubManagement;

import model.BebidaDAO;
import model.Cliente;
import model.ClienteDAO;
import model.ComidaDAO;
import model.ProductoDAO;
import utils.Utils;

public class Controller {
	protected static Cliente usuariologeado;
	protected ProductoDAO pDAO;
	protected ClienteDAO cDAO;
	protected BebidaDAO bebidaDAO;
	protected ComidaDAO comidaDAO;
	protected Utils u;
	public Controller() {
		pDAO = ProductoDAO.getInstance();
		cDAO = ClienteDAO.getInstance();
		bebidaDAO = BebidaDAO.getInstance();
		comidaDAO = ComidaDAO.getInstance();
		u = new Utils();
	}
}
