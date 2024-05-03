package ar.edu.unju.fi.ejercicio07.main;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio05.model.Producto;
import ar.edu.unju.fi.ejercicio05.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio05.model.Producto.Fabricacion;

public class Util {
	public static void precargarProductos(List<Producto> productos) {
		Producto prod1 = new Producto(1110, "Caloventor", 20000, Fabricacion.ARGENTINA, Categoria.ELECTROHOGAR); 
		Producto prod2 = new Producto(1111, "Caladora de madera", 40000, Fabricacion.BRASIL, Categoria.HERRAMIENTAS);
		Producto prod3 = new Producto(1112, "Mouse inalambrico", 13000, Fabricacion.CHINA, Categoria.INFORMATICA);
		Producto prod4 = new Producto(1113, "Telefono de mesa", 37500, Fabricacion.URUGUAY, Categoria.TELEFONIA); prod4.setEstado(false);
		Producto prod5 = new Producto(1114, "Heladera", 630000, Fabricacion.ARGENTINA, Categoria.ELECTROHOGAR);
		Producto prod6 = new Producto(1115, "Amoladora", 40000, Fabricacion.BRASIL, Categoria.HERRAMIENTAS);
		Producto prod7 = new Producto(1116, "Router", 25900, Fabricacion.CHINA, Categoria.INFORMATICA);
		Producto prod8 = new Producto(1117, "Motorola G23", 360000, Fabricacion.URUGUAY, Categoria.TELEFONIA); prod8.setEstado(false);
		Producto prod9 = new Producto(1118, "Microondas", 217000, Fabricacion.ARGENTINA, Categoria.ELECTROHOGAR);
		Producto prod10 = new Producto(1119, "Kit de 4 pinzas", 30500, Fabricacion.BRASIL, Categoria.HERRAMIENTAS);
		Producto prod11 = new Producto(1120, "Monitor", 200300, Fabricacion.CHINA, Categoria.INFORMATICA);
		Producto prod12 = new Producto(1121, "Telefono inalambrico", 70000, Fabricacion.URUGUAY, Categoria.TELEFONIA); prod12.setEstado(false);
		Producto prod13 = new Producto(1122, "Lavarropas", 630000, Fabricacion.ARGENTINA, Categoria.ELECTROHOGAR);
		Producto prod14 = new Producto(1123, "Soldadora", 215000, Fabricacion.BRASIL, Categoria.HERRAMIENTAS);
		Producto prod15 = new Producto(1124, "Taclado inalambrico", 14000, Fabricacion.CHINA, Categoria.INFORMATICA);
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
	
	public static void mostrarProductosDisponibles(List<Producto> productos) {
		System.out.println("\n\t*** PRODUCTOS DISPONIBLES ***");
		Consumer<Producto> mostrar = p -> { 
			if (p.isEstado()) {
				System.out.println(p);
			}
		};
	productos.stream().forEach(mostrar); 	
	}
	
	public static void mostrarNoDisponibles(List <Producto> productos) {
		System.out.println("\n\t*** PRODUCTOS FALTANTES ***");
		Predicate<Producto> condicion = p -> !p.isEstado();
		List<Producto> ProdFaltantes = productos.stream()
				.filter(condicion)
				.collect(Collectors.toList());
		mostrarProductos(ProdFaltantes);
	}

	public static void mostrarProductos(List<Producto> prodFaltantes) {
		for (Producto prod : prodFaltantes) {
			System.out.println(prod);
		}
		
	}

	public static List<Producto> Incrementar(List<Producto> productos) {
		System.out.println("\n\t*** PRECIO INCREMENTADO AL 20% ***");
		Function<Producto,Producto>	nuevoPrecio = p -> {
			p.setPrecio(p.getPrecio()*1.20f);
			return p;
		};
		List<Producto> ProdIncrementados = productos.stream()
				.map(nuevoPrecio)
				.collect(Collectors.toList());
		mostrarProductos(ProdIncrementados);
		return ProdIncrementados;
	}
	
	public static void MostrarCategoria(List<Producto> productos) {
		System.out.println("\n\t*** PRODUCTOS ELECTROHOGAR DISPONIBLES ***");
		Predicate<Producto> condicion = p -> p.getCategoria() == Categoria.ELECTROHOGAR && p.isEstado();
		List<Producto> productosFiltrados = productos.stream().filter(condicion).collect(Collectors.toList());
		mostrarProductos(productosFiltrados);
	}

	public static void OrdenarProdcutos(List<Producto> productos) {
		System.out.println("\n\t*** PRODUCTOS ORDENADOS POR PRECIO ***");
		Comparator<Producto> c= Comparator.comparing(Producto :: getPrecio).reversed();
		productos.sort(c);
		mostrarProductos(productos);
	}

	public static void MostrarPorNombre(List<Producto> productos) {
		System.out.println("\n\t*** PRODUCTOS POR NOMBRE ***");
		Function<Producto,Producto> converitrMayusculas = p -> {
			String nombreMayusculas = p.getDescripcion().toUpperCase();
			p.setDescripcion(nombreMayusculas);
			return p;
		};
		List<Producto> productosMayusculas = productos.stream().map(converitrMayusculas).collect(Collectors.toList());
		mostrarProductos(productosMayusculas);
	}

	
	
	
}
