package utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="conexion")
@XmlAccessorType(XmlAccessType.FIELD)
public class Connect {


	private static Connection con;
	private String file = "conexion.xml";
	private static Connect _newInstance;

	private Connect() {
		//DatosConexion dc = loadFile();
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/"+"pubmanagement","root","");
		} catch (SQLException e) {
			e.printStackTrace();
			con=null;
		}
	}

	public static Connection getConnect() {
		if (_newInstance == null) {
			_newInstance = new Connect();
		}
		return con;
	}

	public DatosConexion loadFile() {
		DatosConexion dc = new DatosConexion();
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(DatosConexion.class);
			Unmarshaller um = contexto.createUnmarshaller();
			DatosConexion newR = (DatosConexion) um.unmarshal(new File(file));
			dc=newR;
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return dc;

	}
}
