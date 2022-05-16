package AntonioJesus.PubManagement;

import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Cliente;

public class SignUpController extends Controller{
	
	
	@FXML
	private TextField txtUser;
	
	@FXML
	private PasswordField txtPassword;
	
	@FXML
	private TextField txtNombre;
	
	@FXML
	private TextField txtApellidos;
	
	@FXML
	private Button btnRegistro;
	
	
	@FXML
	private void registrarUsuario(ActionEvent event) throws IOException {
		Object evt = event.getSource();
		boolean registrado=false;
		if(evt.equals(btnRegistro)) {
			if(!txtUser.getText().isEmpty() 
				&& !txtPassword.getText().isEmpty() 
				&& !txtNombre.getText().isEmpty() 
				&& !txtApellidos.getText().isEmpty()) {
				registrado=utils.Utils.mostrarConfirmacion("A punto de registrar Usuario","¿Esta seguro de Registrar este Usuario?");
				String nombre=txtNombre.getText();
				String apellidos=txtApellidos.getText();
				String contrasena = DigestUtils.sha256Hex(txtPassword.getText());
				String user= txtUser.getText();
				Cliente c = new Cliente(nombre,apellidos,user,contrasena);
				cDAO.insert(c);
				if(registrado) {
					utils.Utils.mostrarInfo("Usuario Registrado Con Exito","","Ya puede iniciar sesión");
					App.setRoot("login");
				}
			}else {
				utils.Utils.mostrarAlerta("Error al Registrar","No se ha podido registrar usuario","Debe rellenar todos los campos");
			}
		}
	}
}
