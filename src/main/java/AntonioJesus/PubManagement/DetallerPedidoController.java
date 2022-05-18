package AntonioJesus.PubManagement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import model.Pedido;
import model.Producto;

public class DetallerPedidoController extends Controller implements Initializable {

	private Pedido p;

	@FXML
	private Button btnVolver;

	@FXML
	private Button btnImprimir;

	@FXML
	private Label codCliente;

	@FXML
	private Label codPedido;

	@FXML
	private Label totalPagar;

	@FXML
	private TextArea productosComprados;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		u.estilo(btnImprimir);
		u.estilo(btnVolver);
		codCliente.setText(Controller.usuariologeado.getNombre());
		codPedido.setText(pedidoDAO.getPedido(Controller.usuariologeado.getCodigo()).getCod_Pedido() + "");
		Float total=0f;
		String productos="";
		for(Producto p:Controller.nuevoPedido) {
			productos+="Nombre: "+p.getNombre()+"Precio: "+p.getPrecio()+"\n";	
			total+=p.getPrecio();
		}
		totalPagar.setText(total+"");
		productosComprados.setText(productos);
		}

	/**
	 * Funcion que te lleva a la ventana anterior.
	 * 
	 * @param evento evento que recibe la funcion.
	 * @throws IOException Excepcion que lanza al cambiar de pantalla
	 */
	public void btnVolver(ActionEvent evento) throws IOException {
		Object evt = evento.getSource();
		if (evt.equals(btnVolver)) {
			App.setRoot("menuPrincipal");
		}
	}

	/**
	 * Funcion que limpia el array y te permite realizar un nuevo pedido.
	 * 
	 * @param evento evento que recibe la funcion.
	 */
	@FXML
	public void btnImprimir(ActionEvent evento) {
		Object evt = evento.getSource();
		if (evt.equals(btnImprimir)) {
			if (!Controller.nuevoPedido.isEmpty()) {

				if (u.mostrarConfirmacion("Finalizar Pedido", "Esta seguro que quiere terminar el pedido")) {
					p = new Pedido(pedidoDAO.getPedido(Controller.usuariologeado.getCodigo()).getCod_Pedido(),
							Controller.nuevoPedido, Controller.usuariologeado.getCodigo());
					pedidoDAO.insert(p);
					Controller.nuevoPedido.clear();
				}
			} else {
				u.mostrarAlerta("Error", "No ha añadido ningun producto al Pedido", "");
			}

		}
	}

}
