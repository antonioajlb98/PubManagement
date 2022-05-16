package AntonioJesus.PubManagement;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.Producto;
import model.ProductoDAO;

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
	private void addProduct(ActionEvent evento) throws IOException {
		Object evt = evento.getSource();
		if (evt.equals(btnAnadir)) {
			if (!txtNombre.getText().isEmpty() && !txtPrecio.getText().isEmpty() && !btnComida.isSelected()
					|| !btnBebida.isSelected()) {
				if(btnBebida.isSelected() && btnComida.isSelected()) {
					utils.Utils.mostrarAlerta("Error al Añadir", "No se ha podido añadir Producto",
							"Solo puede selecionar una categoria.");
				}
				if()
			} else {
				utils.Utils.mostrarAlerta("Error al Añadir", "No se ha podido añadir Producto",
						"Debe rellenar todos los campos.");
			}
		}
	}

}
