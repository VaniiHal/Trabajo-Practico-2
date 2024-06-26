package ar.edu.unju.fi.ejercicio01.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.Fabricacion;

public class Util {
	public static void modificarProductos(List<Producto> productos, Scanner entrada) {
		System.out.println("\n\t*** MODIFICAR PRODUCTOS ***");
		System.out.print("\nIngrese codigo de producto: ");
		int codigo = entrada.nextInt();
		entrada.nextLine();
		boolean encontrado=false;
		for (Producto prod : productos) {
			if (prod.getCodigo()==codigo) {
				modificarDatos(prod,entrada);
				encontrado=true;
			}
		}
		if(encontrado==false) {
			System.out.println("El codigo de producto no se ha encontrado");
		}
	}

	private static void modificarDatos(Producto prod, Scanner entrada) {
		boolean valido=false; int opc=0;
		do {
			try {
				System.out.println("\nDatos del producto");
				System.out.println("1- Descripcion");
				System.out.println("2- Precio");
				System.out.println("3- Categoria");
				System.out.println("4- Fabricacion");
				System.out.print("\nIngresa una opcion: ");
				opc= entrada.nextInt();
				entrada.nextLine();
				switch (opc) {
				case 1: prod.setDescripcion(ingresarDescripcion(entrada)); valido = true; break;
				case 2: prod.setPrecio(ingresarPrecio(entrada)); valido = true; break;
				case 3: prod.setCategoria(ingresarCategoria(entrada)); valido = true; break;
				case 4: prod.setFabricacion(ingresarFabricacion(entrada)); valido = true; break;
				}
			}catch(InputMismatchException ex){
				System.out.println("Error en el ingreso de opcion. Se esperaba un numero");
				entrada.nextLine();			
			}
		} while(!valido);
		System.out.println("Datos modificacos\n" + prod);
	}

	public static void mostrarProducto(List<Producto> productos) {
		System.out.println("\n\t*** MOSTRAR PRODUCTOS ***");
		for (Producto prod : productos) {
			System.out.println(prod);
		}	
	}

	public static void cargarProducto(List<Producto> productos, Scanner entrada) {
		System.out.println("\n\t*** CARGAR PRODUCTOS ***");
		Producto producto = new Producto();		
		producto.setCodigo(ingresarCodigo(entrada,productos));
		producto.setDescripcion(ingresarDescripcion(entrada));
		producto.setPrecio(ingresarPrecio(entrada));
		producto.setFabricacion(ingresarFabricacion(entrada));
		producto.setCategoria(ingresarCategoria(entrada));
		System.out.println(producto);
		productos.add(producto);
	}

	private static Categoria ingresarCategoria(Scanner entrada) {
		int opc=0;
		Producto.Categoria cat=null;
		boolean valida=false;
		do{
			try {
				System.out.println("\n\t*** Categoria ***");
				System.out.println("1- Telefonia");
				System.out.println("2- Informatica");
				System.out.println("3- ElectroHogar");
				System.out.println("4- Herramientas");
				System.out.print("\nElija una opcion: ");
				opc=entrada.nextInt();
				entrada.nextLine();
				
				switch(opc) {
				case 1 : cat=Producto.Categoria.TELEFONIA; valida =true; break;
				case 2 : cat=Producto.Categoria.INFORMATICA; valida =true; break;
				case 3 : cat=Producto.Categoria.ELECTROHOGAR; valida =true; break;
				case 4 : cat=Producto.Categoria.HERRAMIENTAS; valida =true; break;
				default: System.out.println("Ingreso invalido");
				}
			} catch(InputMismatchException ex){
				System.out.println("Error en el ingreso de opcion. Se esperaba un numero");
				entrada.nextLine();		
			}
		}while(!valida);
		return cat;
	}

	private static Fabricacion ingresarFabricacion(Scanner entrada) {
		int opc=0;
		Producto.Fabricacion fab=null;
		boolean valida=false;
		do{
			try {
				System.out.println("\t*** Origen de fabricacion ***");
				System.out.println("1- Argentina");
				System.out.println("2- China");
				System.out.println("3- Brasil");
				System.out.println("4- Uruguay");
				System.out.print("\nElija una opcion: ");
				opc=entrada.nextInt();
				entrada.nextLine();
				
				switch(opc) {
				case 1 : fab=Producto.Fabricacion.ARGENTINA; valida =true; break;
				case 2 : fab=Producto.Fabricacion.CHINA; valida =true; break;
				case 3 : fab=Producto.Fabricacion.BRASIL; valida =true; break;
				case 4 : fab=Producto.Fabricacion.URUGUAY; valida =true; break;
				default: System.out.println("Ingreso invalido");
				}
			} catch(InputMismatchException ex){
				System.out.println("Error en el ingreso de opcion. Se esperaba un numero");
				entrada.nextLine();		
			}
		}while(!valida);
		return fab;
	}

	private static double ingresarPrecio(Scanner entrada) {
		double precio=0.0;
		boolean valido=false;
		do {
			try {
				System.out.print("Ingrese precio: ");
				precio=Double.parseDouble(entrada.nextLine());
				valido=true;
			} catch (NumberFormatException e) {
				System.out.println("El precio ingresado no es valido. Intentelo de nuevo");
			}
		}while(!valido);
		return precio;
	}

	private static String ingresarDescripcion(Scanner entrada) {
		System.out.print("Ingrese descripcion: ");
		String desc=entrada.nextLine();
		return desc;
	}
	
	private static int ingresarCodigo(Scanner entrada, List<Producto> productos) {
		int codigo=0;
		boolean valido=false, encontrado=false;
		do{
			try {
				System.out.print("Ingrese codigo de producto: ");
				codigo=entrada.nextInt();
				entrada.nextLine();
				valido=true;
				encontrado=false;
				for (Producto prod : productos) {
					if(prod.getCodigo()==codigo) {
						encontrado=true;
					}
				}
				if(encontrado==true){
					System.out.println("El codigo esta repetido");
					valido=false;
				}
				else {
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
