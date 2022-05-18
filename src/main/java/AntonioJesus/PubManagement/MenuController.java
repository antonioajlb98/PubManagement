package AntonioJesus.PubManagement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.Pedido;
import utils.Loggers;

public class MenuController extends Controller implements Initializable{
	
	@FXML
	private Button btnNuevoPedido;

	@FXML
	private Button btnEditarPerfil;

	@FXML
	private Button btnEditarProductos;
	
	@FXML
	private Button btnDetallesPedido;

	/**
	 * Funcion para cambiar de pantalla
	 * @param event accion que hay que realizar
	 * @throws IOException excepcion que puede lanzar la funcion al cambiar de pantalla
	 */
	@FXML
	public void eventNuevoPedido(ActionEvent event) throws IOException {
		Object evt = event.getSource();
		if(evt.equals(btnNuevoPedido)) {
			Pedido p = new Pedido(Controller.usuariologeado.getCodigo(),Controller.nuevoPedido);
			pedidoDAO.insert(p);
			App.setRoot("PedidoMenu");
			Loggers.LogsInfo("Cambio de fxml correcto");
		}
	}
	/**
	 * Funcion para cambiar de pantalla
	 * @param event accion que hay que realizar
	 * @throws IOException excepcion que puede lanzar la funcion al cambiar de pantalla
	 */
	@FXML
	public void eventEditarPerfil(ActionEvent event) throws IOException {
		Object evt = event.getSource();
		if(evt.equals(btnEditarPerfil)) {
			App.setRoot("EditarPerfil");
			Loggers.LogsInfo("Cambio de fxml correcto");
		}
	}
	/**
	 * Funcion para cambiar de pantalla
	 * @param event accion que hay que realizar
	 * @throws IOException excepcion que puede lanzar la funcion al cambiar de pantalla
	 */
	@FXML
	public void eventEditarProductos(ActionEvent event) throws IOException {
		Object evt = event.getSource();
		if(evt.equals(btnEditarProductos)) {
			App.setRoot("EditarProductos");
			Loggers.LogsInfo("Cambio de fxml correcto");
		}
	}
	public void btnDetallesPedido(ActionEvent evento) throws IOException {
		Object evt = evento.getSource();
		if(evt.equals(btnDetallesPedido)) {
			App.setRoot("DetallesPedido");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		u.estilo(btnEditarPerfil);
		u.estilo(btnEditarProductos);
		u.estilo(btnNuevoPedido);
		u.estilo(btnDetallesPedido);
	}
}
