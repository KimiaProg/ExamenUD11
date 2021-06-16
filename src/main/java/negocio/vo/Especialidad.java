package negocio.vo;

public enum Especialidad {
	
	PESCADERIA('P',"Pescadería"),
	FRUTERIA('F',"Frutería"),
	CARNICERIA('C',"Carnicería");
	
	private String nombre;
	private Character codigo;
	
	Especialidad(Character codigo, String nombre){
		this.codigo=codigo;
		this.nombre=nombre;
	}
		
	public static Especialidad getByCode(Character c) {
		Especialidad e = null;
		switch (c) {
			case 'P':
				e=PESCADERIA;
				break;
			case 'F':
				e=FRUTERIA;
				break;
			case 'C':
				e=CARNICERIA;
				break;
		}
		return e;
	}
	
	public static Especialidad getByName(String c) {
		Especialidad e = null;
		switch (c) {
			case "Pescadería":
				e=PESCADERIA;
				break;
			case "Frutería":
				e=FRUTERIA;
				break;
			case "Carnicería":
				e=CARNICERIA;
				break;
		}
		return e;
	}
}
