package AntonioJesus.PubManagement;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ComidaController implements Initializable{
	
	
	@FXML
	private GridPane panelComida;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Button btn = new Button();
		panelComida.add(btn, 0, 0);
		
	}
	
	
}
