package AntonioJesus.PubManagement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.Producto;
import utils.Loggers;

public class AnadirProductoController extends Controller implements Initializable{

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
	
	
	/**
	 * Funcion que te lleva a una ventana para añadir un
	 * producto controlando los errores. 
	 * @param evento evento que recibe la funcion.
	 * @throws IOException Excepcion que puede lanzar al cambiar de pantalla.
	 */
	@FXML
	private void addProduct(ActionEvent evento) throws IOException {
		Object evt = evento.getSource();
		if (evt.equals(btnAnadir)) {
			if (!txtNombre.getText().isEmpty() && !txtPrecio.getText().isEmpty()) {
				if (btnBebida.isSelected()) {
					addItem(btnBebida.getText());
					Loggers.LogsInfo("Bebida añadida");
				} else {
					addItem(btnComida.getText());
					Loggers.LogsInfo("Comida añadida");
				}
			} else {
				u.mostrarAlerta("Error al Añadir", "No se ha podido añadir Producto",
						"Debe rellenar todos los campos.");
				Loggers.LogsSevere("Error al añadir");
			}
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
		if (evt.equals(btnVolver)) {
			App.setRoot("EditarProductos");
		}

	}
	
	
	/**
	 * Metodo que añade un producto a la base de datos
	 * @param text El tipo de Producto que es 
	 */
	private void addItem(String tipo) {
		try {
			Float precio = Float.parseFloat(txtPrecio.getText());
			String nombre = txtNombre.getText();
			Producto p = new Producto(nombre, tipo, precio);
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		u.estilo(btnAnadir);
		u.estilo(btnVolver);
		
	}
}
