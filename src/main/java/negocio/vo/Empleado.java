package negocio.vo;

public class Empleado {
	
	private Integer id;
	private String nombre;
	private Integer sueldo;
	private Integer codTienda;
	private Especialidad especialidad;
	
	
	
	public Empleado() {
		super();
	}
	
	public Empleado(Integer id, String nombre, Integer sueldo, Integer codTienda, Especialidad especialidad) {
		this.id = id;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.codTienda = codTienda;
		this.especialidad = especialidad;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getSueldo() {
		return sueldo;
	}
	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}
	public Integer getCodTienda() {
		return codTienda;
	}
	public void setCodTienda(Integer codTienda) {
		this.codTienda = codTienda;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codTienda == null) ? 0 : codTienda.hashCode());
		result = prime * result + ((especialidad == null) ? 0 : especialidad.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((sueldo == null) ? 0 : sueldo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (codTienda == null) {
			if (other.codTienda != null)
				return false;
		} else if (!codTienda.equals(other.codTienda))
			return false;
		if (especialidad != other.especialidad)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (sueldo == null) {
			if (other.sueldo != null)
				return false;
		} else if (!sueldo.equals(other.sueldo))
			return false;
		return true;
	}

}
