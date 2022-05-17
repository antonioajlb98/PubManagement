package model;

import java.util.ArrayList;

public class Pedido {
	private String cod_Pedido;
	private ArrayList<Producto> listaProductos;
	private int cod_cliente;
	
	
	public String getCod_Pedido() {
		return cod_Pedido;
	}
	public void setCod_Pedido(String cod_Pedido) {
		this.cod_Pedido = cod_Pedido;
	}
	public int getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public Pedido(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public Pedido(String cod_Pedido, ArrayList<Producto> listaProductos, int cod_cliente) {
		this.cod_Pedido = cod_Pedido;
		this.listaProductos = listaProductos;
		this.cod_cliente = cod_cliente;
	}
	
	
	
	
	
	
	
	
	
}
