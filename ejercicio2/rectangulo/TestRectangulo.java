package rectangulo;

public class TestRectangulo {

  public static void main(String[] args) {
    try {
      Rectangulo r = new Rectangulo(5, 9);
      System.out.println(r);
    } catch (ArithmeticException e) {
      System.err.println(e.getMessage());
    }
  }

}
