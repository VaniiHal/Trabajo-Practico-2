package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;
import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;

public class Main {

	public static void main(String[] args) {
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)6, 12f);
		//definicion de expresion lambda que 
		//define el convertidor de felino domestico a felino salvaje
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(),x.getEdad(),x.getPeso());
		//se realiza la conversion
		FelinoSalvaje felino1 = converter.convert(gato);
		//mostramos los datos del objeto felino salvaje felino1
		converter.mostrarObjeto(felino1);
		
		
		FelinoSalvaje felino2 = new FelinoSalvaje("Tanner", (byte)20, 186f);
		if (Converter.isNotNull(felino2) == true) {
			Converter<FelinoSalvaje, FelinoDomestico> conversion = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
			FelinoDomestico gato2 =conversion.convert(felino2);
			conversion.mostrarObjeto(gato2);
		}
 	}
}
