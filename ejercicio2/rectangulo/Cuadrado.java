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
    return this.getAncho();
                            
  }
  
    public void setLado(double lado) {
    setAncho(lado);
    setAlto(lado);
  }
  
    @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(getLado());
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  /**
   * equals
   * 
   * @param: objeto cuadrado
   * @return: boolean
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Cuadrado other = (Cuadrado) obj;
    if (Double.doubleToLongBits(getLado()) != Double.doubleToLongBits(other.getLado()))
      return false;
    return true;
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
