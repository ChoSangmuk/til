package object;

public class Phone {
  String modelName;
  int price;
  String os;

  public Phone() {
  }

  public Phone(String modelName, int price, String os) {
    this.modelName = modelName;
    this.price = price;
    this.os = os;
  }

  public static void main(String[] args) {
    Phone p0 = new Phone();
    System.out.println(p0.modelName);
    System.out.println(p0.price);
    System.out.println(p0.os);
    System.out.println();

    p0.modelName = "lg";
    p0.price = 8000;
    p0.os = "ios";
    System.out.println(p0.modelName);
    System.out.println(p0.price);
    System.out.println(p0.os);
    System.out.println();

    Phone p1 = new Phone("ss", 8000, "android");
    System.out.println(p1.modelName);
    System.out.println(p1.price);
    System.out.println(p1.os);
    System.out.println();

    Product tp = new Product();
    System.out.println(tp);
    System.out.println(tp.mouse.pNum);
    System.out.println(tp.mouse.color);
    System.out.println(tp.mouse.country);
    System.out.println(tp.mouse.isWheel);
    System.out.println(tp.mouse.isLen);
    System.out.println();

    System.out.println(tp.phone.modelName);
    System.out.println(tp.phone.price);
    System.out.println(tp.phone.os);
  }
}
