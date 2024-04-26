package ar.edu.unju.fi.ejercicio04.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {

	public static void main(String[] args) {
		int opcion=-1;
		Scanner entrada = new Scanner(System.in);
		List<Jugador> jugadores = new ArrayList<>(); 
		do {
			try {
				System.out.println("\n\t***MENU DE OPCIONES***");
				System.out.println("1- Alta de jugador");
				System.out.println("2- Mostrar todos los jugadores");
				System.out.println("3- Modificar datos del jugador");
				System.out.println("4- Eliminar jugador");
				System.out.println("5- Salir");
				System.out.print("Elija una opcion: ");
				opcion = entrada.nextInt();
				entrada.nextLine(); //se limpia el buffer
				switch (opcion) {
				case 1: Util.cargarJugador(jugadores,entrada); break;
				case 2: if (jugadores.isEmpty()==false) {
					Util.mostrarJugadores(jugadores);
					} else {
						System.out.println("No hay jugadores cargados");
					}
				break;
				case 3: if (jugadores.isEmpty()==false) {
					Util.modificarJugador(jugadores,entrada); 
					} else {
						System.out.println("No hay jugadores cargados");
					}
				break;
				case 4: if (jugadores.isEmpty()==false) {
					Util.eliminarJugador(jugadores,entrada); break;
					} else {
						System.out.println("No hay jugadores cargados");
					}
				break;
				case 5: System.out.println("\tADIOS *-*"); break;
				default: System.out.println("Opcion invalida");
				}
			}catch(InputMismatchException ex){
				System.out.println("Error en el ingreso de opcion. Se esperaba un numero");
			}
		} while(opcion != 5);
		
		entrada.close();
	}
}
