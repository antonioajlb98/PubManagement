package AntonioJesus.PubManagement;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Producto;
import model.ProductoDAO;

public class EditarProductosController extends Controller implements Initializable{
	
	@FXML
	private Button btnAnadir;

	@FXML
	private Button btnEliminar;
	
	@FXML
	private TableView<Producto> tab;
	
	@FXML
	private TableColumn<Producto, String> Nombre;

	@FXML
	private TableColumn<Producto, String> Tipo;
	
	@FXML
	private TableColumn<Producto, String> Precio;
	
	@FXML
	private TableColumn<Producto, String> id;

	private List<Producto> listaProductos = (List<Producto>) ProductoDAO.getAll();
	private final ObservableList<Producto> listaActualizable = FXCollections.observableArrayList(listaProductos);

	private void datosTabla() {
		Nombre.setCellValueFactory(Producto -> {
		SimpleStringProperty ssp = new SimpleStringProperty();
		ssp.setValue(Producto.getValue().getNombre());
		return ssp;
		});
		
		Tipo.setCellValueFactory(Producto -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(Producto.getValue().getTipo());
			return ssp;
			});	
		
		Precio.setCellValueFactory(Producto -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(Producto.getValue().getPrecio()+" €");
			return ssp;
			});	
		
		id.setCellValueFactory(Producto -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(Producto.getValue().getId()+"");
			return ssp;
			});	
		
		}
	@FXML
	private void btnAnadir(ActionEvent evento) throws IOException {
		Object evt = evento.getSource();
		if(evt.equals(btnAnadir)){
			App.setRoot("anadirProducto");
			System.out.println(Controller.usuariologeado.getApellidos());
		}
	}
	
	@FXML
	private void btnEliminar(ActionEvent evento) {
		if (tab.getSelectionModel().isEmpty()) {
			utils.Utils.mostrarAlerta("Error","Debe seleccionar un campo para borrarlo","Intentelo de nuevo");
		}else {
			boolean eliminar=utils.Utils.mostrarConfirmacion();
			if(eliminar) {
				pDAO.delete(tab.getSelectionModel().getSelectedItem());
				listaActualizable.remove(tab.getSelectionModel().getSelectedItem());
				
			}
		}
	}

	@FXML
	public void initialize(URL location, ResourceBundle resources) {
		this.datosTabla();
		tab.setItems(listaActualizable);
		
	}
}
