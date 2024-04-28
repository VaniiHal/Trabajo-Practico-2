package ar.edu.unju.fi.ejercicio02.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class Util {
	public static void modificarEfemeride(List<Efemeride> efemerides, Scanner entrada) {
		System.out.println("\n\t*** MODIFICAR EFEMERIDES ***");
		System.out.print("\nIngrese codigo de efemeride: ");
		int codigo=entrada.nextInt(); boolean encontrado=false;
		entrada.nextLine();
		for(Efemeride efe : efemerides) {
			if(efe.getCodigo()==codigo) {
				encontrado=true;
				efe.setMes(ingresarMes(entrada));
				efe.setDia(ingresarDia(entrada));
				efe.setDetalle(ingresarDetalle(entrada));
				System.out.println("Efemeride modificada: \n" + efe);
			}
		}
		if(encontrado==false) {
			System.out.println("No se ha encontrado ningun dato con ese codigo");
		}
		
	}

	public static void eliminarEfemeride(List<Efemeride> efemerides, Scanner entrada) {
		System.out.println("\n\t*** ELIMINAR EFEMERIDES ***");
		System.out.print("\nIngrese un codigo de efemeride: ");
		int codigo=entrada.nextInt(); boolean encontrado=false;
		entrada.nextLine();
		for(Efemeride efe : efemerides) {
			if(efe.getCodigo()==codigo) {
				encontrado=true;
				System.out.println("Eliminando efemeride: \n" + efe);
				efemerides.remove(efe);
			}
		}
		if(encontrado==false)
		{
			System.out.println("No se ha encontrado ningun dato con ese codigo");
		}
	}

	public static void mostrarEfemerides(List<Efemeride> efemerides) {
		System.out.println("\n\t*** MOSTRAR EFEMERIDES ***");
		for(Efemeride efe : efemerides) {
			System.out.println(efe);
		}
	}

	public static void cargarEfemeride(List<Efemeride> efemerides, Scanner entrada) {
		System.out.println("\n\t*** CARGAR EFEMERIDES ***");
		Efemeride efe = new Efemeride();
		efe.setCodigo(ingresarCodigo(efemerides, entrada));
		efe.setMes(ingresarMes(entrada));
		efe.setDia(ingresarDia(entrada));
		efe.setDetalle(ingresarDetalle(entrada));
		efemerides.add(efe);
		System.out.println("Nueva efemeride cargada correctamente\n" + efe);
	}

	private static String ingresarDetalle(Scanner entrada) {
		System.out.print("\nIngrese detalle de la efemeride: ");
		String detalle=entrada.nextLine();
		return detalle;
	}

	private static int ingresarDia(Scanner entrada) {
		int dia=0; boolean valido=false;
		do {
			try {
				System.out.print("\nIngrese el dia de la efemeride: ");
				dia=entrada.nextInt();
				entrada.nextLine();
				if(dia>=1 && dia<=31) {
					valido=true;
				}
				else {
					System.out.println("Ingreso de dia incorrecto. Intente de nuevo");
				}
			}catch(InputMismatchException ex){
				System.out.println("Error en el ingreso del dato. Se esperaba un numero");
				entrada.nextLine();
			}
		} while(!valido);
		return dia;
	}

	private static Mes ingresarMes(Scanner entrada) {
		int opc=0; boolean valido=false;
		Mes mes= null;
		do {
			try {
				System.out.println("\n\tMes de efemeride");
				System.out.println("1- ENERO");
				System.out.println("2- FEBRERO");
				System.out.println("3- MARZO");
				System.out.println("4- ABRIL");
				System.out.println("5- MAYO");
				System.out.println("6- JUNIO");
				System.out.println("7- JULIO");
				System.out.println("8- AGOSTO");
				System.out.println("9- SEPTIEMBRE");
				System.out.println("10- OCTUBRE");
				System.out.println("11- NOVIEMBRE");
				System.out.println("12- DICIEMBRE");
				System.out.print("Ingrese una opcion: ");
				opc=entrada.nextInt();
				entrada.nextLine();
				switch (opc) {
				case 1: mes=Mes.ENERO; valido=true; break;
				case 2: mes=Mes.FEBRERO; valido=true; break;
				case 3: mes=Mes.MARZO; valido=true; break;
				case 4: mes=Mes.ABRIL; valido=true; break;
				case 5: mes=Mes.MAYO; valido=true; break;
				case 6: mes=Mes.JUNIO; valido=true; break;
				case 7: mes=Mes.JULIO; valido=true; break;
				case 8: mes=Mes.AGOSTO; valido=true; break;
				case 9: mes=Mes.SEPTIEMBRE; valido=true; break;
				case 10: mes=Mes.OCTUBRE; valido=true; break;
				case 11: mes=Mes.NOVIEMBRE; valido=true; break;
				case 12: mes=Mes.DICIEMBRE; valido=true; break;
				default: System.out.println("Opcion invalida. Intente de nuevo");break;
				}
			}catch(InputMismatchException ex){
				System.out.println("Error en el ingreso del dato. Se esperaba un numero");
				entrada.nextLine();
			}
		} while(!valido);
		return mes;
	}

	private static int ingresarCodigo(List<Efemeride> efemerides, Scanner entrada) {
		int codigo=0; boolean valido=false; boolean encontrado=false;
		do {
			try {
				System.out.print("\nIngrese codigo de Efemeride: ");
				codigo= entrada.nextInt();
				entrada.nextLine();
				valido=true;
				encontrado=false;
				for(Efemeride efe: efemerides) {
					if(efe.getCodigo()==codigo) {
						encontrado=true;
					}
				}
				if(encontrado==true) {
					System.out.println("El codigo ya existe. Intente de nuevo");
					valido=false;
				} else {
					valido=true;
				}
			}catch(InputMismatchException ex){
				System.out.println("Error en el ingreso del dato. Se esperaba un numero");
				entrada.nextLine();
			}
		}while(!valido);
		return codigo;
	}


}
