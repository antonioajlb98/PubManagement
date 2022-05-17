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
			App.setRoot("menuPrincipal");
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
					btn.setStyle("-fx-background-color: \r\n"
							+ "        linear-gradient(#ffd65b, #e68400),\r\n"
							+ "        linear-gradient(#ffef84, #f2ba44),\r\n"
							+ "        linear-gradient(#ffea6a, #efaa22),\r\n"
							+ "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\r\n"
							+ "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\r\n"
							+ "    -fx-background-radius: 30;\r\n"
							+ "    -fx-background-insets: 0,1,2,3,0;\r\n"
							+ "    -fx-text-fill: #654b00;\r\n"
							+ "    -fx-font-weight: bold;\r\n"
							+ "    -fx-font-size: 14px;\r\n"
							+ "    -fx-padding: 10 20 10 20;");
					panelBebida.add(btn, j, i);
					cont++;
				}
			}
		}
	}
	
}
