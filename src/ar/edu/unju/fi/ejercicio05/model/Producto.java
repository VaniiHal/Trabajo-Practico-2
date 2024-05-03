package ar.edu.unju.fi.ejercicio05.model;

import java.text.DecimalFormat;

public class Producto {
	private int codigo;
	private String descripcion;
	private double precio;
	private Fabricacion fabricacion;
	private Categoria categoria;
	private boolean estado=true;

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

	public Producto(int codigo, String descripcion, double precio, Fabricacion fabricacion, Categoria categoria) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fabricacion = fabricacion;
		this.categoria = categoria;
	}

	public Producto(int codigo, String descripcion, double precio, Fabricacion fabricacion, Categoria categoria, boolean estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fabricacion = fabricacion;
		this.categoria = categoria;
		this.estado = estado;
	}

	@Override
	public String toString() {
		DecimalFormat formato = new DecimalFormat("#,###.00");
		return "Codigo de producto: " + codigo + "\tDescripcion: " + descripcion + "\tPrecio: $" + formato.format(precio) + "\tFabricacion: "
				+ fabricacion + "\tCategoria: " + categoria + "\tStock: " + (estado==true? "disponible": "no hay disponible"); 
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
