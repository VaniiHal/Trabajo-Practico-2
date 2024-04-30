package ar.edu.unju.fi.ejercicio05.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio05.model.Producto;
import ar.edu.unju.fi.ejercicio05.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio05.model.Producto.Fabricacion;

public class Util {
	
	public static void precargarProductos(List<Producto> productos) {
		Producto prod1 = new Producto(1110, "Caloventor", 20000, Fabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		Producto prod2 = new Producto(1111, "Caladora de madera", 40000, Fabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		Producto prod3 = new Producto(1112, "Mouse inalambrico", 13000, Fabricacion.CHINA, Categoria.INFORMATICA, true);
		Producto prod4 = new Producto(1113, "Telefono de mesa", 37500, Fabricacion.URUGUAY, Categoria.TELEFONIA, true);
		Producto prod5 = new Producto(1114, "Heladera", 630000, Fabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		Producto prod6 = new Producto(1115, "Amoladora", 40000, Fabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		Producto prod7 = new Producto(1116, "Router", 25900, Fabricacion.CHINA, Categoria.INFORMATICA, true);
		Producto prod8 = new Producto(1117, "Motorola G23", 360000, Fabricacion.URUGUAY, Categoria.TELEFONIA, true);
		Producto prod9 = new Producto(1118, "Microondas", 217000, Fabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		Producto prod10 = new Producto(1119, "Kit de 4 pinzas", 30500, Fabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		Producto prod11 = new Producto(1120, "Monitor", 200300, Fabricacion.CHINA, Categoria.INFORMATICA, true);
		Producto prod12 = new Producto(1121, "Telefono inalambrico", 70000, Fabricacion.URUGUAY, Categoria.TELEFONIA, true);
		Producto prod13 = new Producto(1122, "Lavarropas", 630000, Fabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		Producto prod14 = new Producto(1123, "Soldadora", 215000, Fabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		Producto prod15 = new Producto(1124, "Taclado inalambrico", 14000, Fabricacion.CHINA, Categoria.INFORMATICA, true);
		productos.add(prod1);
		productos.add(prod2);
		productos.add(prod3);
		productos.add(prod4);
		productos.add(prod5);
		productos.add(prod6);
		productos.add(prod7);
		productos.add(prod8);
		productos.add(prod9);
		productos.add(prod10);
		productos.add(prod11);
		productos.add(prod12);
		productos.add(prod13);
		productos.add(prod14);
		productos.add(prod15);
	}

	public static void mostrarProductos(List<Producto> productos) {
		System.out.println("\t*** LISTA DE PRODUCTOS ***");
		for (Producto prod: productos) {
			System.out.println(prod);
		}
	}

	public static void mostrarMenuPago(List<Producto> productos, Scanner entrada) {
		int opc =0; boolean valido=false;
		List<Producto> prodSeleccionados = seleccionarProductos(productos,entrada);
		double monto=calcularMonto(prodSeleccionados);
		LocalDate fecha = LocalDate.now();
		do {
			try{
				System.out.println("\n\t***MENU DE PAGO");
				System.out.println("1- Pago en efectivo");
				System.out.println("2- Pago con tarjeta");
				System.out.print("\nElija una opcion: ");
				opc=entrada.nextInt();
				entrada.nextLine();
				switch (opc) {
				
				case 1: PagoEfectivo efectivo = new PagoEfectivo(monto, fecha);
						efectivo.realizarPago(monto);
						efectivo.imprimirRecibo();
						valido=true;
				break;
				case 2: System.out.print("\nIngrese numero de tarjeta: ");
						String numero = entrada.nextLine();
						PagoTarjeta tarjeta = new PagoTarjeta(numero, fecha, monto);
						tarjeta.realizarPago(monto);
						tarjeta.imprimirRecibo();
						valido=true; 
				break;
				default: System.out.println("Opcion invalida. Intente de nuevo");
				}
				
			} catch (InputMismatchException ex) {
				System.out.println("Error en el ingreso de opcion. Intente de nuevo");
				entrada.nextLine();
			}
		}while(!valido);
	}

	private static double calcularMonto(List<Producto> prodSeleccionados) {
		double total =0;
		for(Producto prod : prodSeleccionados) {
			total=total+prod.getPrecio();
		}
		return total;
	}
	
	public static List<Producto> seleccionarProductos(List<Producto> productos, Scanner entrada) {
		List<Producto> prodSeleccionados = new ArrayList<>();
			System.out.println("Seleccione los productos que desea (Seleccione 1 para confirmar o 0 para rechazar)");
			for (int j = 0; j<productos.size(); j++) {
				Producto prod = productos.get(j);
				if (prod.isEstado()==true) {
					System.out.println("\n" + j+1 + ". " + prod.getDescripcion());
					int opc = entrada.nextInt();
					entrada.nextLine();
					if(opc==1) {
						prodSeleccionados.add(prod);
						System.out.println("Producto seleccionado " + prod.getDescripcion());
					}
				}
			}
		return prodSeleccionados;
	}
}
