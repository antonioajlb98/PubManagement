package AntonioJesus.PubManagement;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class EditarPerfilController extends Controller implements Initializable{
	
	
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtApellidos;
	@FXML
	private TextField txtUsuario;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private PasswordField txtPassword1;
	@FXML
	private Button btnActualizar;
	
	@FXML
	private void btnActualizar(ActionEvent evento) {
		Object evt = evento.getSource();
		if(evt.equals(btnActualizar)) {
			if(!txtNombre.getText().isEmpty() 
				&& !txtApellidos.getText().isEmpty()
				&& !txtPassword.getText().isEmpty()
				&& !txtPassword1.getText().isEmpty()) {
				if(txtPassword.getText()!=txtPassword1.getText()) {
					utils.Utils.mostrarAlerta("Las contraseñas no coinciden"
											,"Vuelta a introducir las contraseñas"
											,"Error con las Contraseñas");
				}else {
				}
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/*txtNombre.setText("Hola");
		txtApellidos.setText("Hola");
		txtUsuario.setText("Hola");*/
		System.out.println(Controller.usuariologeado);
		txtNombre.setText(Controller.usuariologeado.getNombre());
		txtApellidos.setText(Controller.usuariologeado.getApellidos());
		txtUsuario.setText(Controller.usuariologeado.getUsuario()); 
	}
	
	
}
