package datos;

import java.time.LocalDate;

public class Persona {
	protected int idPersona;
	protected int dni;
	protected String nombre;
	protected String apellido;
	protected LocalDate fechaDeNacimiento;

	
	public Persona() {
	}
	
	public Persona(int idPersona, int dni, String nombre, String apellido,
			LocalDate fechaDeNacimiento) {
		this.idPersona=idPersona;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		
	}

	public int getIdPersona() {
		return idPersona;
	}

	protected void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", dni=" + dni + ", nombre="
				+ nombre + ", apellido=" + apellido + ", fechaDeNacimiento="
				+ fechaDeNacimiento + ", direccion=";
	}


}
