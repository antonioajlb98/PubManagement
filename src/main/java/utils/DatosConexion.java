package utils;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="conexion")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatosConexion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String server;
	private String database;
	private String user;
	private String password;
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public DatosConexion() {
	}

	public String toString() {
		return "DatosConexion [server=" + server + ", database=" + database + ", user=" + user + ", password="
				+ password + "]";
	}
	
	
	
	
}
