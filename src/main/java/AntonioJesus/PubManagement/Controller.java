package AntonioJesus.PubManagement;

import model.BebidaDAO;
import model.Cliente;
import model.ClienteDAO;
import model.ComidaDAO;
import model.ProductoDAO;

public class Controller {
	
	protected static Cliente usuariologeado;
	protected ProductoDAO pDAO;
	protected ClienteDAO cDAO;
	protected BebidaDAO bebidaDAO;
	protected ComidaDAO comidaDAO;
	
	public Controller() {
		pDAO = ProductoDAO.getInstance();
		cDAO = ClienteDAO.getInstance();
		bebidaDAO = BebidaDAO.getInstance();
		comidaDAO = ComidaDAO.getInstance();
	}
}
