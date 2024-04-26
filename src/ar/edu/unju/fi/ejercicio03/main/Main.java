package ar.edu.unju.fi.ejercicio03.main;

import ar.edu.unju.fi.ejercicio03.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		Provincia[] provincias = Provincia.values();
		for (Provincia prov : provincias) {
			int pob = prov.getPoblacion();
			int sup = prov.getSuperficie();
			double den = prov.calcularDensidad();
			System.out.println("Provincia: " + prov + "\tPoblacion: " + pob + "\tSuperficie: " + sup + "\tDensidad: " + den);
		}
		
	}

}
