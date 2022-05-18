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
import model.Producto;

public class DetallerPedidoController extends Controller implements Initializable{
	
	
	
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
		codCliente.setText(Controller.usuariologeado.getNombre());
		codPedido.setText(pedidoDAO.getPedido(Controller.usuariologeado.getCodigo()).getCod_Pedido()+"");
		for(Producto p:Controller.nuevoPedido) {
			productosComprados.setText(p.toString());
			Float precio=0f;
			precio+=p.getPrecio();
		}
	}
	/**
	 * Funcion que te lleva a la ventana anterior.
	 * @param evento evento que recibe la funcion.
	 * @throws IOException Excepcion que lanza al cambiar de pantalla
	 */
	public void btnVolver(ActionEvent evento) throws IOException {
		Object evt = evento.getSource();
		if(evt.equals(btnVolver)) {
			App.setRoot("PedidoMenu");
		}	
	}
	
	/**
	 * Funcion que limpia el array y te permite realizar un nuevo pedido.
	 * @param evento evento que recibe la funcion.
	 */
	public void btnImprimir(ActionEvent evento) {
		Object evt = evento.getSource();
		if(evt.equals(btnImprimir)) {
			if(u.mostrarConfirmacion("Finalizar Pedido","Esta seguro que quiere terminar el pedido")) {
				Controller.nuevoPedido.clear();
			}	
		}
	}
	
	
	
	
	
	
	
	
}
