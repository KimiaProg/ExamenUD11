package negocio.vo;

import java.time.LocalDate;

/**
 * @author eserrano
 *
 */
public class Persona {

	private String nombre;
	private String dni;
	private LocalDate fechaNacimiento;
	private Float peso;
	private Boolean titulado;
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Persona(String nombre, String dni, LocalDate fechaNacimiento, Float peso, Boolean titulado) {
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.peso = peso;
		this.titulado = titulado;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public Boolean getTitulado() {
		return titulado;
	}
	public void setTitulado(Boolean titulado) {
		this.titulado = titulado;
	}
	
	
}
