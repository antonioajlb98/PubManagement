package AntonioJesus.PubManagement;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import utils.Loggers;

public class PedidoMenuController extends Controller implements Initializable{
	
	@FXML
	private ImageView imgComida;
	@FXML
	private ImageView imgBebida;
	@FXML
	private Button btnVolver;
	
	
	/**
	 * Funcion para cambiar de pantalla
	 * @param event accion que hay que realizar
	 * @throws IOException excepcion que puede lanzar la funcion al cambiar de pantalla
	 */
	@FXML
	public void pulsarComida(MouseEvent evento) throws IOException {
		Object evt = evento.getSource();
		if(evt.equals(imgComida)) {
			App.setRoot("Comida");
			Loggers.LogsInfo("Cambio de fxml correcto");
		}
	}
	
	/**
	 * Funcion para cambiar de pantalla
	 * @param event accion que hay que realizar
	 * @throws IOException excepcion que puede lanzar la funcion al cambiar de pantalla
	 */
	@FXML
	public void pulsarBebida(MouseEvent evento) throws IOException {
		Object evt = evento.getSource();
		if(evt.equals(imgBebida)) {
			App.setRoot("Bebida");
			Loggers.LogsInfo("Cambio de fxml correcto");
		}
	}
	
	/**
	 * Funcion que te lleva a la ventana anterior.
	 * @param evento evento que recibe la funcion.
	 * @throws IOException Excepcion que lanza al cambiar de pantalla
	 */
	@FXML
	private void btnVolver(ActionEvent evento) throws IOException {
		Object evt = evento.getSource();
		if(evt.equals(btnVolver)) {
			App.setRoot("menuPrincipal");
			Loggers.LogsInfo("Cambio de fxml correcto");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		u.estilo(btnVolver);
	}
	
	
	
}
