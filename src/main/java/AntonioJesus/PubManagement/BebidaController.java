package AntonioJesus.PubManagement;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import model.Producto;
import utils.Loggers;

public class BebidaController extends ProductoController implements Initializable{
	
	
	
	@FXML
	private GridPane panelBebida;
	
	/**
	 * Funcion que se inicia al cambiar a esta pantalla
	 * que crea los botones y los añade al gridpanel dependiendo
	 * los productos que haya en el Array.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		scroller.setFitToWidth(true);
		int cont = 0;
		u.estilo(btnVolver);
		ArrayList<Producto> listaBebida = (ArrayList<Producto>) pDAO.getAllBebida();
		panelBebida.setAlignment(Pos.CENTER);

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
					btn.maxWidthProperty();
					btn.setCursor(Cursor.HAND);
					btn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							Controller.nuevoPedido.add(pDAO.getProduct(btn.getText()));
						}
					});
					panelBebida.add(btn, j, i);
					Loggers.LogsInfo("Boton añadido al panel");
					
					cont++;
				}
			}
		}
	}
	
}
