package object;

public class Notebook {
  String productNumber;
  int price;
  String cpu;

  public Notebook() {
    System.out.println("public Notebook()");
    productNumber = "HP201800001";
    price = 1440000;
    cpu = "intel core i7";
  }

  public Notebook(int price) {
    System.out.println("public Notebook(int price)");
    productNumber = "HP201800001";
    this.price = price;
    cpu = "intel core i7";
  }

  public static void main(String[] args) {
    Notebook nb = new Notebook(3000000);
    System.out.println(nb.price);
  }
}
