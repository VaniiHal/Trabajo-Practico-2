package ar.edu.unju.fi.ejercicio05.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio05.model.Producto;



public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		List<Producto> productos = new ArrayList<>();
		Util.precargarProductos(productos);
		int opc=0;
		do {
			try {
				System.out.println("\n\t*** MENU ***");
				System.out.println("1- Mostrar productos");
				System.out.println("2- Realizar compra");
				System.out.println("3- Salir");
				System.out.print("\nElija una opcion: ");
				opc=entrada.nextInt();
				entrada.nextLine();
				switch(opc) {
				case 1: Util.mostrarProductos(productos); break;
				case 2: Util.mostrarMenuPago(productos,entrada); 
				break;
				case 3: System.out.println("\t*** ADIOS ***");break;
				default: System.out.println("Error en el ingreso de opcion. Intente de nuevo");
				}
			} catch(InputMismatchException ex) {
				System.out.println("Error en el ingreso de opcion. Intente de nuevo");
				entrada.nextLine();
			}
		} while(opc!=3);
		entrada.close();
	}
}
