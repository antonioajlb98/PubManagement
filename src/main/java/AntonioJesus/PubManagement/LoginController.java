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

public class LoginController extends Controller implements Initializable {
	
	
	@FXML
	private Button btnRegister;

    @FXML
    private TextField txtUser;
    
    @FXML
    private PasswordField txtPassword;
    
    @FXML 
    private Button btnLogin;
    
    /**
     * Funcion que controla los errores de formulario al logearte y te logea en el programa
     * @param event accion que hay que realizar
     * @throws IOException excepcion que lanza la funcion al cambiar de pantalla
     */
    @FXML
    private void eventAction(ActionEvent event) throws IOException {
    	Object evt = event.getSource();
    	
    	if(evt.equals(btnLogin)) {
    		if(!txtUser.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
    			
    			String user = txtUser.getText();
    			String password = DigestUtils.sha256Hex(txtPassword.getText());
    			if(cDAO.login(user, password)) {
    				Controller.usuariologeado=cDAO.getUser(user);
    				App.setRoot("menuPrincipal");
    				Loggers.LogsInfo("Inicio de sesion y cambio de pantalla correcto");
    			}else {
    				u.mostrarAlerta("Error al iniciar sesion","No se ha podido iniciar sesion","Los datos intrucidos no son correctos");
    			}
    		}else {
    			u.mostrarAlerta("Error al iniciar sesion","No se ha podido iniciar sesion","Debe rellenar todos los campos");
    		}
    	}
    }
    /**
     * Funcion que te cambia de ventana para registarte
     * @param event accion que hay que realizar
     * @throws IOException excepcion que puede lanzar al cambiar de pantalla.
     */
    @FXML
    private void eventRegistro(ActionEvent event) throws IOException {
    	Object evt = event.getSource();
    	if(evt.equals(btnRegister)) {
    		App.setRoot("signup");
    		Loggers.LogsInfo("Cambio de FXML correcto");
    	}
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		u.estilo(btnLogin);
		u.estilo(btnRegister);
	}
    
}
