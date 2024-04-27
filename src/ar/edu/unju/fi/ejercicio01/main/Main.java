package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		List<Producto> productos = new ArrayList<>();
		int opc=0;
		do{
			try {
				System.out.println("\n\t*** MENU DE PRODUCTOS ***");
				System.out.println("1) Crear Producto");
				System.out.println("2) Mostrar productos");
				System.out.println("3) Modificar producto");
				System.out.println("4) Salir");
				System.out.print("Elige una opcion: ");
				opc=entrada.nextInt();
				entrada.nextLine();
				switch(opc) {
				case 1: Util.cargarProducto(productos, entrada); break;
				case 2: if (productos.isEmpty()==false) {
							Util.mostrarProducto(productos);
						} else {
							System.out.println("NO HAY PRODUCTOS CARGADOS");
						}
				break;
				case 3: if (productos.isEmpty()==false) {
							Util.modificarProductos(productos,entrada);
						} else {
							System.out.println("NO HAY PRODUCTOS CARGADOS");
						}
				break;
				case 4: System.out.println("\tADIOS *-*"); break;
				default: ;
				}
			}catch(InputMismatchException ex){
				System.out.println("Error en el ingreso de opcion. Se esperaba un numero");
				entrada.nextLine();			
			}
		}while(opc!=4);
		entrada.close();
	}
}
