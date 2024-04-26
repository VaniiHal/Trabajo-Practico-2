package ar.edu.unju.fi.ejercicio04.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechaNac;
	private String nacionalidad;
	private double estatura;
	private double peso;
	private Posicion posicion;
	
	public Jugador() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Jugador(String nombre, String apellido, LocalDate fechaNac, String nacionalidad, double estatura,
			double peso, Posicion posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}


	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Jugador: " + nombre + "\tApellido: " + apellido + "\tFecha de nacimiento: " + fechaNac.format(formato) + "\tNacionalidad: "+ nacionalidad + "\tEstatura: " + estatura +"cm"+ "\tPeso: " + peso + "kg"+ "\tPosicion: " + posicion;
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
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public double getEstatura() {
		return estatura;
	}
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}


	public int calcularEdad()
	{
		LocalDate hoy =LocalDate.now();
		int edad = Period.between(fechaNac, hoy).getYears();
		return edad;
	}
}
