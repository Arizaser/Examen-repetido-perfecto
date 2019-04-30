package gestisimal.utiles;

/**
 * Clase Menu para mostrar y recoger la opcion del menu
 * 
 * @author Manuel Ariza Serrano
 * @version 1.0
 */
public class Menu {
  String titulo;
  String[] opciones;
  int numOpciones;

  public Menu(String titulo, String[] opciones) {
    this.titulo = titulo;
    this.opciones = opciones;
    this.numOpciones = opciones.length;
  }

  public int gestionar() {
    mostrar();
    return recogerOpcion();
  }

  void mostrar() {
    int i = 1;

    System.out.println(titulo);
    System.out.println("****************************");

    for (String cadena : opciones) {
      System.out.println((i++) + ". " + cadena);
    }

    System.out.println("****************************");

  }

  int recogerOpcion() {
    int opcion;

    do {
      opcion = Teclado.leerEntero("Elige una opcion del 1 al " + numOpciones + ": ");
    } while (opcion < 1 || opcion > numOpciones);

    return opcion;
  }

}
