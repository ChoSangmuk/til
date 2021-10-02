package object;

public class Product {
  Mouse mouse;
  Phone phone;

  public Product() {
    this.mouse = new Mouse();
    this.phone = new Phone();
  }
}
