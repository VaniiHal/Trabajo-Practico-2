package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio05.interfaces.IPago;

public class PagoEfectivo implements IPago {
	private double monto;
	private LocalDate fecha;
	
	public PagoEfectivo() {
		// TODO Auto-generated constructor stub
	}
	
	public PagoEfectivo(double monto, LocalDate fecha) {
		super();
		this.monto = monto;
		this.fecha = fecha;
	}
	
	@Override
	public void realizarPago(double monto) {
		double descuento = monto * 0.1;
		this.monto =monto-descuento;
		
	}

	@Override
	public void imprimirRecibo() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Fecha de pago: " + fecha.format(formato) + "\nMonto total: $" + monto);
		
	}
}
