package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio05.interfaces.IPago;

public class PagoTarjeta implements IPago{
	private String numero;
	private LocalDate fecha;
	private double monto;
	
	public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}

	public PagoTarjeta(String numero, LocalDate fecha, double monto) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.monto = monto;
	}
	
	@Override
	public void realizarPago(double monto) {
		this.monto =monto*1.15;
	}
	
	@Override
	public void imprimirRecibo() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Numero de Tarjeta: " + numero + "\nFecha de pago: " + fecha.format(formato) + "\nMonto total: $" + monto);
		
	}
}
