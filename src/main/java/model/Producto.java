package model;

public class Producto {
	
	protected int id;
	protected String nombre;
	protected String Tipo;
	protected float precio;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Producto(String nombre, String tipo, float precio) {
		this.nombre = nombre;
		Tipo = tipo;
		this.precio = precio;
	}
	public Producto() {
		super();
	}
	@Override
	public String toString() {
		return "Producto id=" + id + ", nombre=" + nombre + ", Tipo=" + Tipo + ", precio=" + precio;
	}
	
	
	
}

