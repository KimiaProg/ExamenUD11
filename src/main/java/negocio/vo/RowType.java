package negocio.vo;

public enum RowType {

	CADENA ("VARCHAR(50)"),
	ENTERO ("INTEGER"),
	LOGICO ("BOOLEAN"),
	REAL("DECIMAL(10)");
	
	private String value;
	
	RowType(String  value) {
		this.value=value;
	}
	
	/**
	 * Método que devuelve la cadena necesaria para definir
	 * una columna mediante un CREATE TABLE en SQL
	 * @return
	 */
	public String getSQLType() {
		return this.value;
	}
	
	/**
	 * No lo necesitas para el examen
	 * @param num
	 * @return
	 */
	public static RowType getByNum(int num) {
		RowType retorno = null;
		
		switch (num%RowType.values().length) {
			case 0:
				retorno = RowType.CADENA;
				break;
			case 1:
				retorno = RowType.ENTERO;
				break;
			case 2:
				retorno = RowType.LOGICO;
				break;
			case 3:
				retorno = RowType.REAL;
				break;
		}
		return retorno;
	}
	
	/**
	 * No lo necesitas para el examen
	 * @param name
	 * @return
	 */
	public static RowType getByName(String name) {
		switch (name.toUpperCase()) {
			case "VARCHAR":
				name = RowType.CADENA.name();
				break;
			case "DECIMAL":
				name = RowType.REAL.name();
				break;
			case "INT":
				name = RowType.ENTERO.name();
				break;
			case "TINYINT":
				name = RowType.LOGICO.name();
				break;
			default:
				break;
		}
		return RowType.valueOf(name.toUpperCase());
	}
}
