package AntonioJesus.PubManagement;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import model.Bebida;
import model.BebidaDAO;

public class BebidaController extends Controller implements Initializable{
	
	
	
	@FXML
	private GridPane panelBebida;
	@FXML
	private Button btnVolver;
	
	@FXML
	private void btnVolver(ActionEvent evento) throws IOException {
		Object evt = evento.getSource();
		if (evt.equals(btnVolver)) {
			App.setRoot("PedidoMenu");
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		int cont = 0;
		ArrayList<Bebida> listaBebida = (ArrayList<Bebida>) BebidaDAO.getAll();

		for (int i = 0; i < panelBebida.getRowCount(); i++) {
			for (int j = 0; j < panelBebida.getColumnCount(); j++) {
				if (cont<listaBebida.size()) {
					Button btn = new Button();
					btn.setText(listaBebida.get(cont).getNombre());
					btn.setWrapText(true);
					btn.setTextAlignment(TextAlignment.CENTER);
					btn.setPrefWidth(620);
					btn.setPrefHeight(503);
					u.estilo(btn);
					panelBebida.add(btn, j, i);
					cont++;
				}
			}
		}
	}
	
}
