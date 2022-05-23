package model;

import java.util.ArrayList;

public class Pedido {
	private int cod_Pedido;
	private ArrayList<Producto> listaProductos;
	private Cliente cliente_pidiendo;
	
	
	
	
	public Pedido() {
		listaProductos = new ArrayList<Producto>();
	}
	public int getCod_Pedido() {
		return cod_Pedido;
	}
	public void setCod_Pedido(int cod_Pedido) {
		this.cod_Pedido = cod_Pedido;
	}
	public Pedido(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public Cliente getCliente_pidiendo() {
		return cliente_pidiendo;
	}
	public void setCliente_pidiendo(Cliente cliente_pidiendo) {
		this.cliente_pidiendo = cliente_pidiendo;
	}
	public Pedido(int cod_Pedido, ArrayList<Producto> listaProductos, Cliente cliente_pidiendo) {
		super();
		this.cod_Pedido = cod_Pedido;
		this.listaProductos = listaProductos;
		this.cliente_pidiendo = cliente_pidiendo;
	}
	public Pedido(Cliente cliente_pidiendo, ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
		this.cliente_pidiendo = cliente_pidiendo;
	}
	
	
	
	
	
	
	
	
	
}
