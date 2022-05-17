package AntonioJesus.PubManagement;

import java.io.IOException;

import javax.swing.ButtonGroup;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.Producto;

public class AnadirProductoController extends Controller {

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtPrecio;

	@FXML
	private Button btnAnadir;

	@FXML
	private RadioButton btnComida;

	@FXML
	private RadioButton btnBebida;

	@FXML
	private Button btnVolver;

	@FXML
	private void addProduct(ActionEvent evento) throws IOException {
		Object evt = evento.getSource();
		if (evt.equals(btnAnadir)) {
			if (!txtNombre.getText().isEmpty() && !txtPrecio.getText().isEmpty()) {
				if (btnBebida.isSelected()) {
					addItem(btnBebida.getText());
				} else {
					addItem(btnComida.getText());
				}
			} else {
				u.mostrarAlerta("Error al Añadir", "No se ha podido añadir Producto",
						"Debe rellenar todos los campos.");
			}
		}
	}

	@FXML
	private void btnVolver(ActionEvent evento) throws IOException {
		Object evt = evento.getSource();
		if (evt.equals(btnVolver)) {
			App.setRoot("EditarProductos");
		}

	}

	private void addItem(String text) {
		try {
			Float precio = Float.parseFloat(txtPrecio.getText());
			String nombre = txtNombre.getText();
			Producto p = new Producto(nombre, text, precio);
			if (pDAO.insert(p)) {
				u.mostrarInfo("Producto añadido", "Todo Correcto", "Ya está el producto disponible");
			} else {
				u.mostrarAlerta("Error al añadir", "No se ha podido añadir el producto", "");
			}
		} catch (NumberFormatException e) {
			u.mostrarAlerta("Error", "Error en el formulario",
					"Debe introducir un numero decimal en el precio");

		}
	}
}
