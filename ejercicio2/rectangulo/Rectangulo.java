package rectangulo;

/**
 * 2.- (Java) Crea la clase Rectángulo de forma que: • Un objeto de esta clase
 * se construye pasándole el ancho y el alto. Ninguno de los dos atributos puede
 * ser menor o igual a cero ni mayor que diez, en esos casos se debe lanzar la
 * excepción ArithmeticException. • Mediante getters y setters permite que se
 * acceda y se modifique el ancho y el alto del rectángulo teniendo en cuenta
 * las restricciones en cuanto a las dimensiones del apartado anterior. • Al
 * imprimir en pantalla un objeto de la clase usando System.out.print se debe
 * dibujar el rectángulo por la pantalla (de manera similar a como se imprime un
 * cuadrado en la página 130 del libro Aprende Java con Ejercicios). • Crea la
 * clase Cuadrado como subclase de Rectángulo. Le debes añadir a su
 * comportamiento la posibilidad de comparar objetos cuadrados entre sí. • Crea
 * los programas de test correspondientes a ambas clases. Debes provocar que se
 * lance la excepción y capturarla.
 * 
 * @author Manuel Ariza Serrano
 *
 */

public class Rectangulo {
  int ancho;
  int alto;

  /**
   * 
   * @param ancho
   * @param alto
   */

  public Rectangulo(int alto, int ancho) {
    setAlto(alto);
    setAncho(ancho);
  }

  int getAncho() {
    return ancho;
  }

  /**
   * 
   * @param ancho
   * @throws ArithmeticException
   */

  void setAncho(int ancho) throws ArithmeticException {
    if (ancho <= 0) {
      throw new ArithmeticException("El ancho no puede ser menor o igual a 0");
    } else if (ancho > 10) {
      throw new ArithmeticException("El alto no puede ser mayor a 10");
    }
    this.ancho = ancho;
  }

  public int getAlto() {
    return alto;
  }

  /**
   * 
   * @param alto
   * @throws ArithmeticException
   */

  void setAlto(int alto) throws ArithmeticException {
    if (alto <= 0) {
      throw new ArithmeticException("El alto no puede ser menor o igual a 0");
    } else if (alto > 10) {
      throw new ArithmeticException("El alto no puede ser mayor a 10");
    }
    this.alto = alto;
  }

  @Override
  public String toString() {
    String resultado = "";
    for (int i = 0; i < ancho; i++) {
      resultado += "**";
    }
    resultado += "\n";

    for (int i = 1; i < alto - 1; i++) {
      resultado += "**";
      for (int espacios = 1; espacios < ancho - 1; espacios++) {
        resultado += "  ";
      }
      resultado += "**\n";
    }

    for (int i = 0; i < ancho; i++) {
      resultado += "**";
    }
    resultado += "\n";

    return resultado;
  }

}
