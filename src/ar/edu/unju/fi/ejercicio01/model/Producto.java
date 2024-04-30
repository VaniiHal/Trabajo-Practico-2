package ar.edu.unju.fi.ejercicio01.model;

public class Producto {
	private int codigo;
	private String descripcion;
	private double precio;
	private Fabricacion fabricacion;
	private Categoria categoria;

	//enums
	public enum Fabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}

	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(int codigo, String descripcion, double precio, Fabricacion fabricacion, Categoria categoria, boolean estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fabricacion = fabricacion;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Codigo de producto: " + codigo + "\tDescripcion: " + descripcion + "\tPrecio: $" + precio + "\tFabricacion: "
				+ fabricacion + "\tCategoria: " + categoria; 
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Fabricacion getFabricacion() {
		return fabricacion;
	}

	public void setFabricacion(Fabricacion fabricacion) {
		this.fabricacion = fabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}


