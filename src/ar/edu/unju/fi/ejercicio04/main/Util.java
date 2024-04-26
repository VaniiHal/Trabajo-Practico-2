package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Util {
	
	public static void eliminarJugador(List<Jugador> jugadores, Scanner entrada) {
		boolean encontrado=false;
		System.out.println("\n\t*** ELIMINACION DE JUGADOR ***");
		System.out.print("\nIngrese nombre del jugador: ");
		String nombre=entrada.nextLine();
		System.out.print("Ingrese apellido del jugador: ");
		String apellido=entrada.nextLine();
		Iterator <Jugador> k = jugadores.iterator();
		while (k.hasNext()) {
			Jugador jugador = k.next();
			if (jugador.getApellido().equalsIgnoreCase(apellido) && jugador.getNombre().equalsIgnoreCase(nombre)) {
				k.remove();
				encontrado=true;
				System.out.println("Jugador eliminado");
				System.out.print("\n");
				//mostrarJugadores(jugadores);
			}
		}
		if (encontrado==false) {
			System.out.println("El jugador no se encuentra en la lista");
		}	
	}
	
	public static void modificarJugador(List<Jugador> jugadores, Scanner entrada) {
		boolean encontrado=false;
		System.out.print("\n\t*** MODIFICACION DE JUGADOR ***");
		System.out.print("\nIngrese nombre del jugador: ");
		String nombre=entrada.nextLine();
		System.out.print("Ingrese apellido del jugador: ");
		String apellido=entrada.nextLine();
		int k=0; 
		while (k<jugadores.size() && encontrado==false) {
			Jugador jugador = jugadores.get(k);
			if (jugador.getApellido().equalsIgnoreCase(apellido) && jugador.getNombre().equalsIgnoreCase(nombre)) {
				modificarDatos(jugador,entrada);
				System.out.println("Datos del jugador modificados\n" + jugador);
				encontrado=true;
			}
			k++;
		}
		if (encontrado==false) {
			System.out.println("El jugador no se encuentra en la lista");
		}
	}
	
	public static void modificarDatos(Jugador jugador, Scanner entrada) {
		int opc=0;
		do {
			try {
				System.out.println("\n\tQue dato desea modificar?");
				System.out.println("1) Nombre");
				System.out.println("2) Apellido");
				System.out.println("3) Fecha de nacimiento");
				System.out.println("4) Estatura");
				System.out.println("5) Nacionalidad");
				System.out.println("6) Peso");
				System.out.println("7) Posicion");
				System.out.println("8) Menu anterior");
				System.out.print("Elija una opcion: ");
				opc=entrada.nextInt();
				entrada.nextLine();
				switch (opc) {
				case 1: System.out.print("Ingrese nombre del jugador: ");
						String nombre=entrada.nextLine();
						jugador.setNombre(nombre);
						break;
				case 2: System.out.print("Ingrese apellido del jugador: ");
						String apellido=entrada.nextLine();
						jugador.setApellido(apellido);
						break;
				case 3: LocalDate fechaNac =ingresarFecha(entrada); 
						jugador.setFechaNac(fechaNac);
						break;
				case 4: System.out.print("Ingrese nacionalidad del jugador: ");
						String nacionalidad= entrada.nextLine();
						jugador.setNacionalidad(nacionalidad);
						break;
				case 5: System.out.print("Ingrese altura del jugador en cm: ");
						double altura = entrada.nextDouble();
						jugador.setEstatura(altura);
						break;
				case 6: System.out.print("Ingrese peso del jugador: ");
						double peso = entrada.nextDouble();
						jugador.setPeso(peso);
						break;
				case 7: Posicion posicion = ingresarPosicion(entrada);
						jugador.setPosicion(posicion);
						break;
				case 8: System.out.println("\tADIOS *-*"); break;
				default: System.out.println("Opcion invalida");
				}
			}catch(InputMismatchException ex) {
				System.out.println("Error en el ingreso de opcion. Se esperaba un numero");
			}
		}while(opc!=8);
		
	}
	
	public static void mostrarJugadores(List<Jugador> jugadores) {
		System.out.println("\n\t*** MOSTRAR JUGADORES***");
		for(Jugador jugador : jugadores) {
			System.out.println(jugador);
		}
	}
	public static void cargarJugador(List<Jugador> jugadores, Scanner entrada) {
		System.out.println("\n\t*** ALTA DE JUGADOR ***");
		System.out.print("\nIngrese nombre del jugador: ");
		String nombre=entrada.nextLine();
		
		System.out.print("Ingrese apellido del jugador: ");
		String apellido=entrada.nextLine();

		LocalDate fechaNac =ingresarFecha(entrada);
		
		System.out.print("Ingrese nacionalidad del jugador: ");
		String nacionalidad= entrada.nextLine();

		
		double altura=ingresarDato(entrada, "altura"); 
		double peso=ingresarDato(entrada,"peso");
		Posicion posicion = ingresarPosicion(entrada);
		
		Jugador jugador = new Jugador(nombre, apellido, fechaNac, nacionalidad, altura, peso, posicion);
		System.out.println("Se agrega a la lista el jugador\n" + jugador );
		jugadores.add(jugador);
	}

	private static double ingresarDato(Scanner entrada, String cad) {
		double dato=0;
		while (dato==0) {
			try {
				System.out.print("Ingrese " + cad + " del jugador: ");
				dato = Double.parseDouble(entrada.nextLine());
			}catch(NumberFormatException ex) {
				System.out.println("Se esperaba un numero decimal. Revise el ingreso");
			}
		}
		return dato;
	}

	private static Posicion ingresarPosicion(Scanner entrada) {
		Posicion posicion=null;
		boolean band=false;
		do {
			try {
				System.out.println("\nPosicion del jugador (DELANTERO, MEDIO, DEFENSA, ARQUERO) ");
				System.out.println("1) DELANTERO");
				System.out.println("2) MEDIO");
				System.out.println("3) DEFENSA");
				System.out.println("4) ARQUERO");
				System.out.print("Elija una opcion: ");
				int opc = entrada.nextInt();
				entrada.nextLine();
				switch (opc){
				case 1: posicion= Posicion.DELANTERO; band=true; break;
				case 2: posicion= Posicion.MEDIO; band=true; break;
				case 3: posicion= Posicion.DEFENSA; band=true; break;
				case 4: posicion= Posicion.ARQUERO; band=true; break;
				default: System.out.println("Posicion invalida");
				}
			}catch(InputMismatchException ex){
				System.out.println("Error en el ingreso de opcion. Se esperaba un numero");
				entrada.nextLine();
			}
		}while(band==false);
		return posicion;
	}

	private static LocalDate ingresarFecha(Scanner entrada) {
		LocalDate fechaNac=null;
		while (fechaNac == null) {
			System.out.print("Ingrese fecha de Nacimiento (Formato dd/mm/yyyy): ");
			String fecha = entrada.nextLine();
			try {
				DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/yyyy"); //como se hace en el caso de que la fecha sea ilogica? 30 de febrero 
				fechaNac = LocalDate.parse(fecha,formato);
			}catch(DateTimeParseException e) {
				System.out.println("\nError en el ingreso de la fecha de nacimeinto. Intentalo de nuevo\n");
			}
		}
		return fechaNac;
	}

}
