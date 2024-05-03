package ar.edu.unju.fi.ejercicio07.main;

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
			System.out.println("\n\t*** MENU ***");
			System.out.println("1. Mostrar productos");
			System.out.println("2. Mostrar productos faltantes");
			System.out.println("3. Incrementar los precios de los productos un 20%");
			System.out.println("4. Mostrar los productos que corresponden a la categoria Electrohogar");
			System.out.println("5. Ordenar los productos por precio de forma decreciente");
			System.out.println("6. Mostrar los productos con los nombres en mayusculas");
			System.out.println("7. Salir");
			try {
				System.out.print("\nElije una opcion: ");
				opc= entrada.nextInt();
				entrada.nextLine();
				switch (opc){
				case 1: Util.mostrarProductosDisponibles(productos); break;
				case 2: Util.mostrarNoDisponibles(productos); break;
				case 3: productos=Util.Incrementar(productos); break;
				case 4: Util.MostrarCategoria(productos); break;
				case 5: Util.OrdenarProdcutos(productos); break;
				case 6: Util.MostrarPorNombre(productos); break;
				case 7: System.out.println("\t ADIOS"); break;
				default: System.out.println();
				}
			} catch(InputMismatchException ex) {
				System.out.println("Error en el ingreso. Intente de nuevo");
				entrada.nextLine();
			}
		}while(opc!=7);
		entrada.close();
	}
}
