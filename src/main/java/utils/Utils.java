package utils;

import java.io.IOException;
import java.util.Optional;

import AntonioJesus.PubManagement.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Utils {
	
	public Utils() {
	}
	
	private static Scene scene;
	private static Stage stage;
	
	public void mostrarAlerta(String title, String header, String description) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(description);
		alert.showAndWait();
	}
	public void mostrarInfo(String title, String header, String description) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(description);
        alert.show();
    }
	public boolean mostrarConfirmacion() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar");
        alert.setHeaderText("A punto de eliminar");
        alert.setContentText("¿Desea borrar la cuenta?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }
	public void changeScene(String fxml) throws IOException {
		stage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
		scene = new Scene (fxmlLoader.load());
		stage.setScene(scene);
		stage.show();
	}
	public boolean mostrarConfirmacion(String header,String description) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar");
        alert.setHeaderText(header);
        alert.setContentText(description);
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
	}
	public void parseFloat(String convert) {
		try {
			Float num = Float.parseFloat(convert);
		}catch(NumberFormatException e) {
			mostrarAlerta("Error", "Error en el formulario",
					"Debe introducir un numero decimal en el precio");
		}
	}
	
	public void estilo(Button btn) {
		btn.setStyle("-fx-background-color: \r\n"
				+ "        linear-gradient(#ffd65b, #e68400),\r\n"
				+ "        linear-gradient(#ffef84, #f2ba44),\r\n"
				+ "        linear-gradient(#ffea6a, #efaa22),\r\n"
				+ "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\r\n"
				+ "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\r\n"
				+ "    -fx-background-radius: 30;\r\n"
				+ "    -fx-background-insets: 0,1,2,3,0;\r\n"
				+ "    -fx-text-fill: #654b00;\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n"
				+ "    -fx-padding: 10 20 10 20;");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
