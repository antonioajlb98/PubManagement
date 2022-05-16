package AntonioJesus.PubManagement;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PedidoMenuController extends Controller{
	
	@FXML
	private ImageView imgComida;
	
	@FXML
	private ImageView imgBebida;
	
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
	
	
}
