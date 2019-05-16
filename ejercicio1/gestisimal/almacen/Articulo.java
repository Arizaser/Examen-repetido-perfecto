package gestisimal.almacen;

import java.util.InputMismatchException;

import gestisimal.utiles.Teclado;

/**
 * Clase Articulo con los atributos principales
 * 
 * @author Manuel Ariza Serrano
 * @version 1.0
 */

/**
 * 1.- (Java) Añade el tipo de IVA a la clase Artículo usada en la clase Almacén
 * hecha en clase y modifica el código necesario para poder aplicarlo: •
 * Recuerda que hay tres tipos de IVA: general, reducido y super reducido. •
 * Solicita el tipo de IVA mediante un menú. Al objeto lo llamarás menuIva. •
 * Añade el IVA tanto a la opción de alta como a la de modificación de artículo
 * en la clase Almacén y en aquellos otras clases que sea necesario. • En la
 * clase Artículo, en caso de que el iva sea null lanzarás una excepción
 * IvaInvalidoException. • Actualiza el estado/comportamiento de la(s) clase(s)
 * afectada(s).
 *
 */

public class Articulo {
	private static int cont = 1;
	private int codigo;
	private String descripcion;
	private double precioCompra;
	private double precioVenta;
	private int stock;
	private Iva iva;

	Articulo(String descripcion, double precioCompra, double precioVenta, int stock, Iva iva)
	    throws ValorNoValidoException, IvaInvalidoException {
		setDescripcion(descripcion);
		setPrecioCompra(precioCompra);
		setPrecioVenta(precioVenta);
		setStock(stock);
		setIva(iva);
		setCodigo();
	}

	Articulo(int codigo) {
		this.codigo = codigo;
	}

	public Iva getIva() {
		return iva;
	}

	private void setIva(Iva iva) throws IvaInvalidoException {
		if (iva == null) {
			throw new IvaInvalidoException("\nIVA no valido\n");
		}
		this.iva = iva;
	}

	int getCodigo() {
		return codigo;
	}

	private void setCodigo() {
		this.codigo = Articulo.cont++;
	}

	String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	double getPrecioCompra() {
		return precioCompra;
	}

	private void setPrecioCompra(double precioCompra) throws ValorNoValidoException {
		if (precioCompra < 0) {
			throw new ValorNoValidoException("\nEl precio de compra no puede ser menor de 0\n");
		}

		this.precioCompra = precioCompra;

	}

	double getPrecioVenta() {
		return precioVenta;
	}

	private void setPrecioVenta(double precioVenta) throws ValorNoValidoException {
		if (precioVenta < 0) {
			throw new ValorNoValidoException("\nEl precio de venta no puede ser menor de 0\n");
		}

		this.precioVenta = precioVenta;
	}

	int getStock() {
		return stock;
	}

	private void setStock(int stock) throws ValorNoValidoException {
		if (stock < 0) {
			throw new ValorNoValidoException("\nEl stock no puede ser menor de 0\n");
		}

		this.stock = stock;
	}

	void aumentarStock(int num) throws ValorNoValidoException {
		if (num < 0) {
			throw new ValorNoValidoException("\nEl stock no puede ser menor de 0\n");
		}

		setStock(stock + num);
	}

	void decrementarStock(int num) throws ValorNoValidoException {
		if (num < 0) {
			throw new ValorNoValidoException("\nEl stock no puede ser menor de 0\n");
		}

		setStock(stock - num);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	void set(String descripcion, double precioCompra, double precioVenta, int stock, Iva iva)
	    throws ValorNoValidoException, IvaInvalidoException {
		setDescripcion(descripcion);
		setPrecioCompra(precioCompra);
		setPrecioVenta(precioVenta);
		setStock(stock);
		setIva(iva);
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("\n****************************");
		sb.append("\nCódigo: " + this.codigo);
		sb.append("\nDescripcion: " + this.descripcion);
		sb.append("\nPrecio de compra: " + this.precioCompra);
		sb.append("\nPrecio de venta: " + this.precioVenta);
		sb.append("\nStock: " + this.stock);
		sb.append("\nIVA: " + this.iva);
		sb.append("\n****************************\n");

		return sb.toString();
	}
}
