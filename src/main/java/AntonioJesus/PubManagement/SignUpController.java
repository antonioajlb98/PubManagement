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
import model.Cliente;
import utils.Loggers;

public class SignUpController extends Controller implements Initializable{
	
	
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
	private Button btnVolver;
	
	/**
	 * Fuincion que Registra un usuario y lo inserta en la base de datos
	 * controlando los errores de formulario
	 * @param event accion que hay que realizar
	 * @throws IOException excepcion que puede lanzar.
	 */
	@FXML
	private void registrarUsuario(ActionEvent event) throws IOException {
		Object evt = event.getSource();
		boolean registrado=false;
		if(evt.equals(btnRegistro)) {
			if(!txtUser.getText().isEmpty() 
				&& !txtPassword.getText().isEmpty() 
				&& !txtNombre.getText().isEmpty() 
				&& !txtApellidos.getText().isEmpty()) {
				registrado=u.mostrarConfirmacion("A punto de registrar Usuario","¿Esta seguro de Registrar este Usuario?");
				String nombre=txtNombre.getText();
				String apellidos=txtApellidos.getText();
				String contrasena = DigestUtils.sha256Hex(txtPassword.getText());
				String user= txtUser.getText();
				Cliente c = new Cliente(nombre,apellidos,user,contrasena);
				cDAO.insert(c);
				if(registrado) {
					u.mostrarInfo("Usuario Registrado Con Exito","","Ya puede iniciar sesión");
					Loggers.LogsInfo("Inicio de sesion exitoso");
					App.setRoot("login");
				}
			}else {
				u.mostrarAlerta("Error al Registrar","No se ha podido registrar usuario","Debe rellenar todos los campos");
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
		if(evt.equals(btnVolver)) {
			App.setRoot("login");
			Loggers.LogsInfo("Cambio de fxml correcto");
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
			u.estilo(btnRegistro);
			u.estilo(btnVolver);
		}
}
