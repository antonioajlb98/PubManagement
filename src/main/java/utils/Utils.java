package utils;

import java.io.IOException;
import java.util.Optional;

import AntonioJesus.PubManagement.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Utils {
	private static Scene scene;
	private static Stage stage;
	
	public static void mostrarAlerta(String title, String header, String description) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(description);
		alert.showAndWait();
	}
	public static void mostrarInfo(String title, String header, String description) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(description);
        alert.show();
    }
	public static boolean mostrarConfirmacion() {
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
	public static void changeScene(String fxml) throws IOException {
		stage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
		scene = new Scene (fxmlLoader.load());
		stage.setScene(scene);
		stage.show();
	}
	public static boolean mostrarConfirmacion(String header,String description) {
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
}
