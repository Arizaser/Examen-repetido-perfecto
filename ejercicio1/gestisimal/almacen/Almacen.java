package gestisimal.almacen;

import java.util.ArrayList;

/**
 * Clase Almacen gestionar el funcionamiento del almacen
 * 
 * @author Manuel Ariza Serrano
 * @version 1.0
 */

public class Almacen {

	private ArrayList<Articulo> arraylist = new ArrayList<Articulo>();

	public void annadirArticulo(String descripcion, double precioCompra, double precioVenta, int stock, Iva iva)
	    throws ArticuloExisteException, ValorNoValidoException, IvaInvalidoException {
		Articulo articulo = new Articulo(descripcion, precioCompra, precioVenta, stock, iva);

		if (arraylist.contains(articulo)) {
			throw new ArticuloExisteException("\nEl articulo ya existe en el almacen\n");
		}

		arraylist.add(articulo);
	}

	public boolean borrarArticulo(int codigo) {
		return arraylist.remove(new Articulo(codigo));
	}

	public void modificarArticulo(Articulo articulo, String descripcion, double precioCompra, double precioVenta,
	    int stock, Iva iva) throws ValorNoValidoException, IvaInvalidoException {
		articulo.set(descripcion, precioCompra, precioVenta, stock, iva);
		arraylist.set(arraylist.indexOf(articulo), arraylist.get(arraylist.indexOf(articulo)));
	}

	public Articulo get(int codigo) throws CodigoNoValidoException {
		try {

			return arraylist.get(arraylist.indexOf(new Articulo(codigo)));

		} catch (IndexOutOfBoundsException e) {
			throw new CodigoNoValidoException("\nEl codigo del articulo no esta en el almacen\n");
		}
	}

	public void aumentarStock(int codigo, int numero) throws ValorNoValidoException {
		Articulo articulo = arraylist.get(arraylist.indexOf(new Articulo(codigo)));
		articulo.aumentarStock(numero);
	}

	public void decrementarStock(int codigo, int numero) throws ValorNoValidoException {
		Articulo articulo = arraylist.get(arraylist.indexOf(new Articulo(codigo)));
		articulo.decrementarStock(numero);
	}

	@Override
	public String toString() {
		return "Almacen: \n" + arraylist;
	}

}
