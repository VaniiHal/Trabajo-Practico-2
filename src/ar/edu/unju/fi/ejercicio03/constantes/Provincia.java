package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	JUJUY(1_121_183, 53_219), 
	SALTA(1_579_051, 155_488),
	TUCUMAN(1_677_130, 22_524),
	CATAMARCA(418_991, 102_602),
	LA_RIOJA(393_531, 89_680),
	SANTIAGO_DEL_ESTERO(950_041, 136_351);

	private int poblacion;
	private int superficie;
	
	private Provincia(int poblacion, int superficie) {
		this.poblacion = poblacion;
		this.superficie = superficie;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	public double calcularDensidad() {
		return poblacion/superficie;
	}
}
