package AntonioJesus.PubManagement;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Producto;

public class EditarProductosController extends Controller implements Initializable {

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

	@FXML
	private Button btnVolver;

	private List<Producto> listaProductos = (List<Producto>) pDAO.getAll();
	private final ObservableList<Producto> listaActualizable = FXCollections.observableArrayList(listaProductos);

	@FXML
	private void btnAnadir(ActionEvent evento) throws IOException {
		Object evt = evento.getSource();
		if (evt.equals(btnAnadir)) {
			App.setRoot("anadirProducto");
		}
	}

	@FXML
	private void btnEliminar(ActionEvent evento) {
		if (tab.getSelectionModel().isEmpty()) {
			u.mostrarAlerta("Error", "Debe seleccionar un campo para borrarlo", "Intentelo de nuevo");
		} else {
			boolean eliminar = u.mostrarConfirmacion();
			if (eliminar) {
				pDAO.delete(tab.getSelectionModel().getSelectedItem());
				listaActualizable.remove(tab.getSelectionModel().getSelectedItem());

			}
		}
	}

	@FXML
	private void btnVolver(ActionEvent evento) throws IOException {
		Object evt = evento.getSource();
		if (evt.equals(btnVolver)) {
			App.setRoot("menuPrincipal");
		}
	}

	@FXML
	public void initialize(URL location, ResourceBundle resources) {
		tab.setItems(listaActualizable);
		Nombre.setCellValueFactory(cellData -> {
			return new SimpleObjectProperty<>(cellData.getValue().getNombre());
		});
		Nombre.setCellFactory(TextFieldTableCell.forTableColumn());
		Nombre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Producto, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Producto, String> t) {
				Producto selected = (Producto) t.getTableView().getItems().get(t.getTablePosition().getRow());
				selected.setNombre(t.getNewValue());
				pDAO.update(selected);
			}
		});
		Tipo.setCellValueFactory(cellData -> {
			return new SimpleObjectProperty<>(cellData.getValue().getTipo());
		});
		Tipo.setCellFactory(TextFieldTableCell.forTableColumn());
		Tipo.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Producto, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Producto, String> t) {
				Producto selected = (Producto) t.getTableView().getItems().get(t.getTablePosition().getRow());
				if(checkTipo(t.getNewValue())) {
					selected.setTipo(t.getNewValue());
					pDAO.update(selected);
				}
				
			}
		});
		Precio.setCellValueFactory(cellData -> {
			return new SimpleObjectProperty<>(cellData.getValue().getPrecio()+"€");
		});
		Precio.setCellFactory(TextFieldTableCell.forTableColumn());
		Precio.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Producto, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Producto, String> t) {
				Producto selected = (Producto) t.getTableView().getItems().get(t.getTablePosition().getRow());
				try {
					Float precio = Float.parseFloat(t.getNewValue());
					selected.setPrecio(precio);
					pDAO.update(selected);
				}catch(NumberFormatException e){
					u.mostrarAlerta("Error", "Error en el formulario",
							"Debe introducir un numero decimal en el precio");
				}
				
			}
		});
		id.setCellValueFactory(cellData -> {
			return new SimpleObjectProperty<>(cellData.getValue().getId()+"");
		});
		tab.setEditable(true);
		tab.getSelectionModel().cellSelectionEnabledProperty().set(true);
	}
	public boolean checkTipo(String tipo) {
		boolean correct=false;
		if(!tipo.equals("Bebida") || !tipo.equals("Comida")) {
			u.mostrarAlerta("Error","Solo puedes Introducir como tipo 'Comida' o 'Bebida'","");
			correct=false;
		}
		if(tipo.equals("Bebida") || tipo.equals("Comida")) {
			correct=true;
		}
		return correct;
		
		
		
		
		
		
		
	}
}
