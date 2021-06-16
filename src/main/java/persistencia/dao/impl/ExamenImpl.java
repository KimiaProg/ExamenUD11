package persistencia.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import negocio.vo.Empleado;
import negocio.vo.Especialidad;
import negocio.vo.Persona;
import negocio.vo.RowDescriptor;
import negocio.vo.TableDescriptor;
import negocio.vo.Tienda;
import negocio.vo.User;
import persistencia.dao.ExamenDAO;

public class ExamenImpl implements ExamenDAO {

	private static final String LOGIN_QUERY = "select * from Users where username= ? and passwd=?;";
	private static final String TABLE_QUERY = "create table ? (? ?);";
	private static final String TABLEFILAS = "ALTER TABLE ? ADD ? ?;";
	private static final String INSERT_QUERY = "insert into Personas values(?,?,?,?,?);";
	private static final String TIENDA_EMPLE = "select * from Empleado where idTienda = ?";
	private static final String TIENDA = "select * from Tienda where idTienda = ?";

	@Override
	public User login(Connection conexion, String username, String password) {
		String sql = LOGIN_QUERY;
		User user = null;
		try {
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, username);
			sentencia.setString(2, password);
			ResultSet rs = sentencia.executeQuery();
			if (rs.next()) {
				user = new User(username, password);
			}
		} catch (SQLException e) {
			System.out.println("Error");
		}
		return user;
	}

	@Override
	public void createTable(Connection conexion, TableDescriptor table) {
		String sql = TABLE_QUERY;
		try {
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, table.getTableName());
			sentencia.setString(2, table.getFilas().get(0).getRowName());
			sentencia.setString(3, table.getFilas().get(0).getRowType().getSQLType());
			sentencia.execute();
			
			String sqlAlter = TABLEFILAS;
			PreparedStatement sentenciaA = conexion.prepareStatement(sqlAlter);
			
			sentenciaA.setString(1, table.getTableName());
			for (int i = 1; i < table.getFilas().size(); i++) {
				sentenciaA.setString(2, table.getFilas().get(i).getRowName());
				sentenciaA.setString(3, table.getFilas().get(i).getRowType().getSQLType());
				sentenciaA.execute();
			}
			
		} catch (SQLException e) {
			System.out.println("Error");
		}
	}

	@Override
	public void insertaPersona(Connection conexion, Persona persona) {
		String sql = INSERT_QUERY;
		try {
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, persona.getNombre());
			sentencia.setString(2, persona.getDni());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String date = persona.getFechaNacimiento().format(formatter);
			sentencia.setString(3, date);
			sentencia.setDouble(4, persona.getPeso());
			sentencia.setBoolean(5, persona.getTitulado());
			sentencia.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error");
		}
	}

	@Override
	public Tienda recuperaTienda(Connection conexion, Integer codigo) {
		String sql = TIENDA_EMPLE;
		String sqlT = TIENDA;
		Tienda t = null;
		try {
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			PreparedStatement sentenciaT = conexion.prepareStatement(sqlT);
			sentenciaT.setInt(1, codigo);
			sentencia.setInt(1, codigo);
			ResultSet rsT = sentenciaT.executeQuery();
			ResultSet rs = sentencia.executeQuery();
			if (rsT.next()) {
				t = new Tienda();
				t.setNombre(rsT.getString("nombre"));
				t.setDireccion(rsT.getString("direccion"));
				t.setCodTienda(codigo);
				t.setEmpleadosTienda(construyeLista(rs));
			}
		} catch (SQLException e) {
			System.out.println("Error");
		}
		return t;
	}

	private static List<Empleado> construyeLista(ResultSet rs) throws SQLException {
		List<Empleado> catalogo = new ArrayList<>();
		while (rs.next()) {
			Empleado p = new Empleado();
			p.setId(rs.getInt("idEmpleado"));
			p.setNombre(rs.getString("nombre"));
			p.setSueldo(rs.getInt("sueldo"));
			p.setCodTienda(rs.getInt("idTienda"));
			Especialidad esp = Especialidad.getByCode(rs.getString("idEspecialidad").toCharArray()[0]);
			p.setEspecialidad(esp);
			catalogo.add(p);
		}
		return catalogo;
	}

	@Override
	public void insertaPersonasLote(Connection conexion, List<Persona> personas) {
		String sql = INSERT_QUERY;
		try {
			conexion.setAutoCommit(false);
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			for (Persona p : personas) {
				sentencia.setString(1, p.getNombre());
				sentencia.setString(2, p.getDni());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String date = p.getFechaNacimiento().format(formatter);
				sentencia.setString(3, date);
				sentencia.setDouble(4, p.getPeso());
				sentencia.setBoolean(5, p.getTitulado());
				sentencia.executeUpdate();
			}
			conexion.commit();
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println("Error");
		}
	}

}
