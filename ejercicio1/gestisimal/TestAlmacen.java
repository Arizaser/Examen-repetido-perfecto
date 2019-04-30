package gestisimal;

import java.util.InputMismatchException;

import gestisimal.almacen.*;
import gestisimal.utiles.*;

/**
 * Crea el programa GESTISIMAL (GESTIón SIMplificada de Almacén) para llevar el
 * control de los artículos de un almacén. De cada artículo se debe saber el
 * código, la descripción, el precio de compra, el precio de venta y el stock
 * (número de unidades). El menú del programa debe tener, al menos, las
 * siguientes opciones: 1. Listado 2. Alta 3. Baja 4. Modificación 5. Entrada de
 * mercancía 6. Salida de mercancía 7. Salir La entrada y salida de mercancía
 * supone respectivamente el incremento y decremento de stock de un determinado
 * artículo. Hay que controlar que no se pueda sacar más mercancía de la que hay
 * en el almacén.
 * 
 * @author Manuel Ariza Serrano
 * @version 1.0
 */

public class TestAlmacen {

  private static Almacen almacen = new Almacen();
  private static Menu menu = new Menu("Almacen", new String[] { "Listado", "Alta", "Baja", "Modificación",
      "Entrada de mercancía", "Salida de mercancía", "Salir" });

  public static void main(String[] args) {
    int opcion = 0;

    do {

      opcion = menu.gestionar();

      switch (opcion) {
      case 1:
        System.out.println("\n" + almacen + "\n");
        break;
      case 2:
        annadir();
        break;
      case 3:
        borrar();
        break;
      case 4:
        modificar();
        break;
      case 5:
        aumentar();
        break;
      case 6:
        decrementar();
        break;
      case 7:
        System.out.println("\nSaliendo....");
        break;
      default:
        System.err.println("\nOpcion no valida (1 al 7)\n");
        break;
      }

    } while (opcion != 7);

  }

  public static Iva elegirIva() {
    Menu menuIva = new Menu("Elija el tipo de iva:", new String[] { "General", "Reducido", "Superreducido", "Salir" });
    int opcion = 0;

    opcion = menuIva.gestionar(); // Pide al usuario introducir un numero para escoger la opcion
    switch (opcion) {
    case 1:
      return Iva.GENERAL;
    case 2:
      return Iva.REDUCIDO;
    case 3:
      return Iva.SUPERREDUCIDO;
    default:
      System.out.println("Volviendo al menu principal...");
      return null;
    }

  }

  static void annadir() {
    try {

      almacen.annadirArticulo(Teclado.leerCadena("\nDescripcion: "), Teclado.leerDecimal("Precio de compra: "),
          Teclado.leerDecimal("Precio de venta: "), Teclado.leerEntero("Stock: "), elegirIva());
      System.out.println("\nArticulo añadido correctamente\n");

    } catch (ArticuloExisteException | IvaInvalidoException | ValorNoValidoException e) {
      System.err.println(e.getMessage());
    }
  }

  static void borrar() {
    try {

      System.out.println("\n" + almacen);
      int codigo = Teclado.leerEntero("\nIntroduce el codigo del articulo que quieras borrar del almacen: ");

      almacen.get(codigo);
      almacen.borrarArticulo(codigo);
      System.out.println("\nArticulo borrado correctamente\n");

    } catch (CodigoNoValidoException e) {
      System.err.println(e.getMessage());
    }

  }

  static void modificar() {
    try {

      System.out.println("\n" + almacen);
      int codigo = Teclado.leerEntero("\nIntroduce el codigo del articulo que quieras modificar del almacen: ");
      Articulo articulo = almacen.get(codigo);
      System.out.println("\n" + articulo);

      almacen.modificarArticulo(articulo, Teclado.leerCadena("\nDescripcion: "),
          Teclado.leerDecimal("Precio de compra: "), Teclado.leerDecimal("Precio de venta: "),
          Teclado.leerEntero("Stock: "), elegirIva());
      System.out.println("\nArticulo modificado correctamente\n");

    } catch (CodigoNoValidoException | IvaInvalidoException | ValorNoValidoException e) {
      System.err.println(e.getMessage());
    }

  }

  static void aumentar() {
    try {

      System.out.println("\n" + almacen);
      int codigo = Teclado.leerEntero("\nIntroduce el codigo del articulo al que quiera aumentar el stock: ");
      Articulo articulo = almacen.get(codigo);
      System.out.println("\n" + articulo);

      almacen.aumentarStock(codigo, Teclado.leerEntero("En cuanto quieres aumentar el stock: "));
      System.out.println("\nStock aumentado correctamente\n");

    } catch (ValorNoValidoException | CodigoNoValidoException e) {
      System.err.println(e.getMessage());
    }

  }

  static void decrementar() {
    try {

      System.out.println("\n" + almacen);
      int codigo = Teclado.leerEntero("\nIntroduce el codigo del articulo al que quiera decrementar el stock: ");
      Articulo articulo = almacen.get(codigo);
      System.out.println("\n" + articulo);

      almacen.decrementarStock(codigo, Teclado.leerEntero("\nEn cuanto quieres decrementar el stock: "));
      System.out.println("\nStock decrementado correctamente\n");

    } catch (ValorNoValidoException | CodigoNoValidoException e) {
      System.err.println(e.getMessage());
    }

  }

}
