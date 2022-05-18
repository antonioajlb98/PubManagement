package model;

import java.util.ArrayList;

public class Pedido {
	private int cod_Pedido;
	private ArrayList<Producto> listaProductos;
	private int codCliente;
	
	
	
	
	public Pedido() {
		listaProductos = new ArrayList<Producto>();
	}
	public int getCod_Pedido() {
		return cod_Pedido;
	}
	public void setCod_Pedido(int cod_Pedido) {
		this.cod_Pedido = cod_Pedido;
	}
	public int getCod_cliente() {
		return codCliente;
	}
	public void setCod_cliente(int cod_cliente) {
		this.codCliente = cod_cliente;
	}
	public Pedido(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public Pedido(int cod_Pedido, ArrayList<Producto> listaProductos, int cod_cliente) {
		this.cod_Pedido = cod_Pedido;
		this.listaProductos = listaProductos;
		this.codCliente = cod_cliente;
	}
	public Pedido( int cod_cliente, ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
		this.codCliente = cod_cliente;
	}
	
	
	
	
	
	
	
	
	
}
