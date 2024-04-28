package ar.edu.unju.fi.ejercicio02.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		List<Efemeride> efemerides = new ArrayList<>();
		int opc=0;
		do {
			try {
				System.out.println("\n\t*** MENU ***");
				System.out.println("1- Crear efemeride");
				System.out.println("2- Mostrar efemerides");
				System.out.println("3- Eliminar efemeride");
				System.out.println("4- Modificar efemeride");
				System.out.println("5- Salir");
				System.out.print("\nElija una opcion: ");
				opc=entrada.nextInt();
				entrada.nextLine();
				switch (opc) {
				case 1: Util.cargarEfemeride(efemerides,entrada); break;
				case 2: if (efemerides.isEmpty()==false) { 
							Util.mostrarEfemerides(efemerides);
						} else {
							System.out.println("NO HAY EFEMERIDES CARGADAS");
						}
				break;
				case 3: if (efemerides.isEmpty()==false) {
							Util.eliminarEfemeride(efemerides,entrada);
						} else {
							System.out.println("NO HAY EFEMERIDES CARGADAS");
						}
				break;
				case 4: if (efemerides.isEmpty()==false) {
							Util.modificarEfemeride(efemerides,entrada);
						} else {
							System.out.println("NO HAY EFEMERIDES CARGADAS");
						}
				break;
				case 5: System.out.println("\t*** ADIOS ***");break;
				default: System.out.println("Opcion invalida. Vuelva a intentar");
				}
			}catch(InputMismatchException ex){
				System.out.println("Error en el ingreso de opcion. Se esperaba un numero");
				entrada.nextLine();			
			}
		}while(opc!=5);
		entrada.close();	
	}
}
