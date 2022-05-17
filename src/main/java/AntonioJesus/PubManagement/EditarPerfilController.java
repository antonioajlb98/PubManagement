package AntonioJesus.PubManagement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.codec.digest.DigestUtils;

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
	private Button btnVolver;
	
	@FXML
	private void btnActualizar(ActionEvent evento) throws IOException {
		Object evt = evento.getSource();
		if(evt.equals(btnActualizar)) {
			if(!txtNombre.getText().isEmpty() 
				&& !txtApellidos.getText().isEmpty()
				&& !txtPassword.getText().isEmpty()
				&& !txtPassword1.getText().isEmpty()) {
				if(!txtPassword.getText().equals(txtPassword1.getText())) {
					u.mostrarAlerta("Las contraseñas no coinciden"
											,"Vuelva a introducir las contraseñas"
											,"Error con las Contraseñas");
				}
				if(txtPassword.getText().equals(txtPassword1.getText())) {
					Controller.usuariologeado.setNombre(txtNombre.getText());
					Controller.usuariologeado.setApellidos(txtApellidos.getText());
					Controller.usuariologeado.setUsuario(txtUsuario.getText());
					Controller.usuariologeado.setContrasena(DigestUtils.sha256Hex(txtPassword.getText()));
					if(cDAO.update(usuariologeado)) {
						u.mostrarInfo("Perfil Actualizado","El perfil se ha actualizado correctamente","");
						App.setRoot("menuPrincipal");
					}else {
						u.mostrarInfo("Error","No se ha podido actualizar el perfil","");
					}
				}
			}else {
				u.mostrarAlerta("Error al iniciar sesion","No se ha podido iniciar sesion","Debe rellenar todos los campos");
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtNombre.setText(Controller.usuariologeado.getNombre());
		txtApellidos.setText(Controller.usuariologeado.getApellidos());
		txtUsuario.setText(Controller.usuariologeado.getUsuario()); 
	}
	@FXML
	private void btnVolver(ActionEvent evento) throws IOException {
		Object evt = evento.getSource();
		if(evt.equals(btnVolver)) {
			App.setRoot("menuPrincipal");
		}
	}
	
	
}
