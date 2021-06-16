package negocio.vo;

import java.util.List;

/**
 * Describe una tabla de base de datos en una estructura de objetos
 * 
 * @author eserrano
 *
 */
public class TableDescriptor {
	
	private String tableName;
	private List<RowDescriptor> filas;
	
	public TableDescriptor(String tableName, List<RowDescriptor> filas) {
		this.tableName = tableName;
		this.filas = filas;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<RowDescriptor> getFilas() {
		return filas;
	}
	public void setFilas(List<RowDescriptor> filas) {
		this.filas = filas;
	}
	
}
