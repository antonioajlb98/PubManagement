package AntonioJesus.PubManagement;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import model.Comida;
import model.ComidaDAO;

public class ComidaController extends Controller implements Initializable {

	@FXML
	private GridPane panelComida;
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
		panelComida.maxHeightProperty();
		panelComida.maxHeightProperty();
		ArrayList<Comida> listaComida = (ArrayList<Comida>) ComidaDAO.getAll();
		panelComida.setAlignment(Pos.CENTER);

		for (int i = 0; i < panelComida.getRowCount(); i++) {
			for (int j = 0; j < panelComida.getColumnCount(); j++) {
				if (cont<listaComida.size()) {
					Button btn = new Button();
					btn.setText(listaComida.get(cont).getNombre());
					btn.setWrapText(true);
					btn.setTextAlignment(TextAlignment.CENTER);
					btn.setPrefWidth(620);
					btn.setPrefHeight(503);
					u.estilo(btn);
					btn.maxWidthProperty();
					panelComida.add(btn, j, i);
					cont++;
				}
			}
		}

	}
	
	
	

}
