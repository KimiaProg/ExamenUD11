package negocio.vo;

import java.util.List;

public class Tienda {
	
	private Integer codTienda;
	private String nombre;
	private String direccion;
	
	private List<Empleado> empleadosTienda;

	public Tienda() {
		super();
	}
	
	public Tienda(Integer codTienda, String nombre, String direccion) {
		this.codTienda = codTienda;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public Tienda(Integer codTienda, String nombre, String direccion, List<Empleado> empleadosTienda) {
		this.codTienda = codTienda;
		this.nombre = nombre;
		this.direccion = direccion;
		this.empleadosTienda = empleadosTienda;
	}


	public Integer getCodTienda() {
		return codTienda;
	}

	public void setCodTienda(Integer codTienda) {
		this.codTienda = codTienda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Empleado> getEmpleadosTienda() {
		return empleadosTienda;
	}

	public void setEmpleadosTienda(List<Empleado> empleadosTienda) {
		this.empleadosTienda = empleadosTienda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codTienda == null) ? 0 : codTienda.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((empleadosTienda == null) ? 0 : empleadosTienda.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Tienda other = (Tienda) obj;
		if (codTienda == null) {
			if (other.codTienda != null)
				return false;
		} else if (!codTienda.equals(other.codTienda))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (empleadosTienda == null) {
			if (other.empleadosTienda != null)
				return false;
		} else if (!empleadosTienda.equals(other.empleadosTienda))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}
