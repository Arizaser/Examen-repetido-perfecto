package rectangulo;

public class Cuadrado extends Rectangulo implements Comparable<Cuadrado> {

  /**
   * 
   * @param alto
   */
  public Cuadrado(int l) {
    super(l, l);
  }

  public int getLado() {
    return this.getAncho(); // Aprovechamos los getters del rectangulo(padre), por ejemplo el ancho
                            // ya que tanto ancho como alto tienen el mismo valor en el cuadrado.
  }

  @Override
  public int compareTo(Cuadrado otro) {
    if (otro.getLado() == this.getLado())
      return 0;

    if (otro.getLado() > this.getLado())
      return -1;

    return 1;

  }

}
