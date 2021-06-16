package persistencia.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class GenericDAOImpl {

	private static Connection conexion = null;
	static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static String conecctionURI;
	private static String user;
	private static String password;

	/**
	 * El método debe devolver una conexión activa a base de datos con los
	 * parámetros que haya establecidos en las propiedades estáticas de la clase.
	 * 
	 * NOTA: Debes codificar correctamente los getters/setters de las propiedades
	 * estáticas
	 * 
	 * @param individual si es true la conexión debe ser independiente de cualquier
	 *                   otra, si es false se debe devolver una conexión compartida.
	 * @return la conexion a utilizar
	 */
	public static final Connection getConnection(boolean individual) {
		Connection devolver = conexion;
		if (!individual) {
			if (conexion == null) {
				try {
					conexion = DriverManager.getConnection(getConecctionURI(), getUser(), getPassword());
					if (!conexion.getAutoCommit())
						conexion.setAutoCommit(true);
					devolver = conexion;
				} catch (SQLException e) {
					System.out.println("Error conectando a BD");
					e.printStackTrace();
				}
			}
		} else {
			Connection conexion = null;
			try {

				conexion = DriverManager.getConnection(getConecctionURI(), getUser(), getPassword());
				devolver = conexion;
			} catch (SQLException e) {
				System.out.println("Error conectando a BD");
				e.printStackTrace();
			}
		}
		return devolver;
	}

	public static Connection getConexion() {
		return conexion;
	}

	public static void setConexion(Connection conexion) {
		GenericDAOImpl.conexion = conexion;
	}

	public static String getConecctionURI() {
		return conecctionURI;
	}

	public static void setConecctionURI(String conecctionURI) {
		GenericDAOImpl.conecctionURI = conecctionURI;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		GenericDAOImpl.user = user;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		GenericDAOImpl.password = password;
	}

}
