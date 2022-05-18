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
import utils.Loggers;

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
	
	/**
	 * Funcion que sirve para controlar los errores al actualizar 
	 * nuestro perfil y setea estos cambios y los updatea en la BBDD
	 * @param evento accion que hay que realizar 
	 * @throws IOException Excepcion que lanza la funcion al cambiar de pantalla
	 */
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
						Loggers.LogsInfo("Usuario Actualizado con exito");
						App.setRoot("menuPrincipal");
					}else {
						u.mostrarInfo("Error","No se ha podido actualizar el perfil","");
						Loggers.LogsSevere("Error al actualizar");
					}
				}
			}else {
				u.mostrarAlerta("Error al iniciar sesion","No se ha podido iniciar sesion","Debe rellenar todos los campos");
				Loggers.LogsSevere("No ha Rellenado los campos");
			}
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtNombre.setText(Controller.usuariologeado.getNombre());
		txtApellidos.setText(Controller.usuariologeado.getApellidos());
		txtUsuario.setText(Controller.usuariologeado.getUsuario()); 
		u.estilo(btnActualizar);
		u.estilo(btnVolver);
	}
	
	/**
	 * Funcion que te lleva a la ventana anterior.
	 * @param evento evento que recibe la funcion.
	 * @throws IOException Excepcion que lanza al cambiar de pantalla
	 */
	@FXML
	private void btnVolver(ActionEvent evento) throws IOException {
		Object evt = evento.getSource();
		if(evt.equals(btnVolver)) {
			App.setRoot("menuPrincipal");
		}
	}
	
	
}
