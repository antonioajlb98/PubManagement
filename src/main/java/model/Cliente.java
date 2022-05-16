package model;

public class Cliente {
	protected int codigo;
	protected String nombre;
	protected String apellidos;
	protected String usuario;
	protected String contrasena;
	
	public Cliente() {
		super();
	}
	public Cliente(String nombre, String apellidos, String usuario, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	public Cliente(int codigo,String usuario,String nombre,String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@Override
	public String toString() {
		return "Cliente codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", usuario=" + usuario
				+ ", contrasena=" + contrasena;
	}
	
	
	
}
