package persistencia.dao;

import java.sql.Connection;
import java.util.List;

import negocio.vo.Persona;
import negocio.vo.TableDescriptor;
import negocio.vo.Tienda;
import negocio.vo.User;

public interface ExamenDAO {

	/**
	 * Metodo para hacer login a una BD de forma segura.
	 * 
	 * Forma segura quiere decir que debe estar libre de la posibilidad
	 * de SQL Injection.
	 * 
	 * @param conexion objeto de conexión a la BD contra la que hacer login.
	 * @param username cadena nombre de usuario
	 * @param password cadena con el password
	 * @return POJO User construido con los datos recuperados de la BD, null en caso
	 * de login incorrecto.
	 */
	User login(Connection conexion, String username, String password);
	
	/**
	 * Recibe la descripción de una tabla a crear en base de datos.
	 * 
	 * NOTA: El primer campo de la tabla debe definirse como PRIMARY KEY
	 * 
	 * @param table Tabla a crear
	 */
	void createTable(Connection conexion, TableDescriptor table);
	
	/**
	 * Recibe un objeto persona y lo guarda en la tabla Personas
	 * @param conexion para insertar el objeto
	 * @param persona a insertar en BD
	 */
	void insertaPersona(Connection conexion, Persona persona);
	
	/**
	 * Construye un objeto Tienda con todos sus empleados también correctamente configurados
	 * @param codigo de la tienda recuperar
	 * @param conexion para construir el objeto
	 * @return
	 */
	Tienda recuperaTienda(Connection conexion, Integer codigo);
	
	/**
	 * Insertar personas en modo transacción. Se insertan todas o ninguna.
	 * 
	 * Si el test da falso y crees que lo tienes bien, prueba a hacer un clean con Gradle
	 * 
	 * @param personas Lista de personas a insertar.
	 * @param conexion para insertar los objetos
	 */
	void insertaPersonasLote(Connection conexion, List<Persona> personas);
}
