package AntonioJesus.PubManagement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MenuController extends Controller implements Initializable{
	
	@FXML
	private Button btnNuevoPedido;

	@FXML
	private Button btnEditarPerfil;

	@FXML
	private Button btnEditarProductos;


	@FXML
	public void eventNuevoPedido(ActionEvent event) throws IOException {
		Object evt = event.getSource();
		if(evt.equals(btnNuevoPedido)) {
			App.setRoot("PedidoMenu");
		}
	}
	
	@FXML
	public void eventEditarPerfil(ActionEvent event) throws IOException {
		Object evt = event.getSource();
		if(evt.equals(btnEditarPerfil)) {
			App.setRoot("EditarPerfil");
		}
	}
	
	@FXML
	public void eventEditarProductos(ActionEvent event) throws IOException {
		Object evt = event.getSource();
		if(evt.equals(btnEditarProductos)) {
			App.setRoot("EditarProductos");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		u.estilo(btnEditarPerfil);
		u.estilo(btnEditarProductos);
		u.estilo(btnNuevoPedido);
	}
}
