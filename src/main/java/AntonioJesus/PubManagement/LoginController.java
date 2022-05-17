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

public class LoginController extends Controller implements Initializable {
	
	
	@FXML
	private Button btnRegister;

    @FXML
    private TextField txtUser;
    
    @FXML
    private PasswordField txtPassword;
    
    @FXML 
    private Button btnLogin;
    
    
    @FXML
    private void eventAction(ActionEvent event) throws IOException {
    	Object evt = event.getSource();
    	
    	if(evt.equals(btnLogin)) {
    		if(!txtUser.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
    			
    			String user = txtUser.getText();
    			String password = DigestUtils.sha256Hex(txtPassword.getText());
    			if(cDAO.login(user, password)) {
    				Controller.usuariologeado=cDAO.getLogeado(user);
    				App.setRoot("menuPrincipal");
    			}else {
    				u.mostrarAlerta("Error al iniciar sesion","No se ha podido iniciar sesion","Los datos intrucidos no son correctos");
    			}
    		}else {
    			u.mostrarAlerta("Error al iniciar sesion","No se ha podido iniciar sesion","Debe rellenar todos los campos");
    		}
    	}
    }
    
    @FXML
    private void eventRegistro(ActionEvent event) throws IOException {
    	Object evt = event.getSource();
    	if(evt.equals(btnRegister)) {
    		App.setRoot("signup");
    	}
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
    
}
