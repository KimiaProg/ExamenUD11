package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import clases.helpers.Aleatorios;
import clases.helpers.TesterDAO;
import negocio.vo.Empleado;
import negocio.vo.Especialidad;
import negocio.vo.Persona;
import negocio.vo.Tienda;

public class MiddleTest extends TestBase {
	

	protected static Connection conexion = null;
	

	
	@BeforeAll
	static void setUpBD() {
		TesterDAO.setConecctionURI(C.connectionURI);
		TesterDAO.setPassword(C.password);
		TesterDAO.setUser(C.user);
		conexion=TesterDAO.getSharedConnection();
	}
	
	@BeforeEach
	void setUp() {
		super.setUp();
		conexion = TesterDAO.getSharedConnection();
	}
	
	@AfterEach
	void tearDown() {
		println("");
		super.tearDown();
	}

	List<Persona> damePersonas(){
		List<Persona> lista = new ArrayList<>();
		int num = Aleatorios.numeroAleatorio(6, 10);
		
		for (int i = 0; i < num; i++) {
			lista.add(crearPersonaAleatoria(i+1));
		}
		
		return lista;
	}

	
	Tienda test04Aux(Connection conexion, Integer i) throws SQLException {
		Tienda a = getT(conexion, i);
		if(a!=null)
			a.setEmpleadosTienda(getEmpT(conexion, i));
		return a;
	}
	
	Tienda test04AuxFalse(Connection conexion, Integer i) throws SQLException {
		Tienda a = getT(conexion, i);
		return a;
	}
	
	Tienda getT(Connection conexion, Integer cod) throws SQLException{
		Tienda coco = null;
		
		PreparedStatement sentencia = conexion.prepareStatement(C.TIE);
		sentencia.setInt(1, cod);
		
		ResultSet rs =sentencia.executeQuery();
		
		if(rs.next()) {
			coco=new Tienda();
			coco.setCodTienda(rs.getInt(1));
			coco.setNombre(rs.getString(2));
			coco.setDireccion(rs.getString(3));
		}
		
		return coco;
	}

	
	Persona crearPersonaAleatoria(int dif) {
		
		String nombre = Aleatorios.cadenaAleatoria(5, 8);
		String dni = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddHHmmSS")) 
				+ Aleatorios.cadenaAleatoria(1, 1).toUpperCase();
		if(dif!=0)
			dni = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddHHmm"))
				+ Integer.toString(dif)
				+ Aleatorios.cadenaAleatoria(1, 1).toUpperCase();
		LocalDate fechaNacimiento = Aleatorios.fecha(Aleatorios.numeroAleatorio(1960, 2000));
		Float peso = Aleatorios.numeroAleatorio(50, 110f);
		peso = (float) (Math.round(peso*100f)/100);
		Boolean titulado = Aleatorios.numeroAleatorio(0, 1)==0; 
		Persona p = new Persona(nombre, dni, fechaNacimiento, peso, titulado);
		return p;
	}
	
	List<Empleado> getEmpT(Connection conexion, Integer cod) throws SQLException{
		List<Empleado> lista = new ArrayList<>();
		
		PreparedStatement sentencia = conexion.prepareStatement(C.EMPTI);
		sentencia.setInt(1, cod);
		
		ResultSet rs =sentencia.executeQuery();
		
		while(rs.next()) {
			Integer co = rs.getInt(1);
			String no = rs.getString(2);
			Integer sal = rs.getInt(3);
			Integer ti = rs.getInt(4);
			Character esp = rs.getString(5).charAt(0);
			Empleado e = new Empleado(co, no, sal, ti, Especialidad.getByCode(esp));
			lista.add(e);
		}
		
		return lista;
	}
	
}
