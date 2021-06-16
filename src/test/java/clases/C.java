package clases;

public class C {
	
	static String connectionURI="jdbc:mysql://localhost:6033/examen?characterEncoding=utf8";
	static String user="developer";
	static String password="programaciondaw";
	
	static String EMPTI = "SELECT * FROM Empleado WHERE idTienda=?;";
	static String TIE = "SELECT * FROM Tienda WHERE idTienda=?;";

}
