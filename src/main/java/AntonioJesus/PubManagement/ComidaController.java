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

public class ComidaController extends ProductoController implements Initializable {
	
	@FXML
	private GridPane panelComida;
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
		ArrayList<Producto> listaComida = (ArrayList<Producto>) pDAO.getAllComida();
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
					btn.setCursor(Cursor.HAND);
					btn.maxWidthProperty();
					btn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							Controller.nuevoPedido.add(pDAO.getProduct(btn.getText()));
							Loggers.LogsInfo(nuevoPedido.toString());
						}
					});
					panelComida.add(btn, j, i);
					Loggers.LogsInfo("Boton añadido al panel");
					
					cont++;
				}
			}
		}		
	}
	
	
	

}
