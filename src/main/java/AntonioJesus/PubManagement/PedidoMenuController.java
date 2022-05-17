package AntonioJesus.PubManagement;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PedidoMenuController extends Controller{
	
	@FXML
	private ImageView imgComida;
	@FXML
	private ImageView imgBebida;
	@FXML
	private Button btnVolver;
	
	@FXML
	public void pulsarComida(MouseEvent evento) throws IOException {
		Object evt = evento.getSource();
		if(evt.equals(imgComida)) {
			App.setRoot("Comida");
		}
	}
	
	@FXML
	public void pulsarBebida(MouseEvent evento) throws IOException {
		Object evt = evento.getSource();
		if(evt.equals(imgBebida)) {
			App.setRoot("Bebida");
		}
	}
	@FXML
	private void btnVolver(ActionEvent evento) throws IOException {
		Object evt = evento.getSource();
		if(evt.equals(btnVolver)) {
			App.setRoot("menuPrincipal");
		}
	}
	
	
	
}
