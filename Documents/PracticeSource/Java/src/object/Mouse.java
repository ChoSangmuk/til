package object;

public class Mouse {
  int pNum;
  String color;
  String country;
  boolean isWheel;
  byte isLen;

  // 오버로딩 overloading
  public Mouse() {
    pNum = 88;
    color = "led";
    country = "kor";
    isWheel = true;
    isLen = 1;
  }

  public Mouse(int i, String string, String string2, boolean b, int j) {
    pNum = i;
    color = string;
    country = string2;
    isWheel = b;
    isLen = (byte) j;
  }

  public static void main(String[] args) {
    Mouse m = new Mouse();
    System.out.println(m.pNum);
    System.out.println(m.color);
    System.out.println(m.country);
    System.out.println(m.isWheel);
    System.out.println(m.isLen);
    System.out.println();

    m.pNum = 33;
    m.color = "blue";
    m.country = "us";
    m.isWheel = false;
    m.isLen = 3;
    System.out.println(m.pNum);
    System.out.println(m.color);
    System.out.println(m.country);
    System.out.println(m.isWheel);
    System.out.println(m.isLen);
    System.out.println();

    Mouse tm = new Mouse(1, "gold", "ge", false, 1);
    System.out.println(tm.pNum);
    System.out.println(tm.color);
    System.out.println(tm.country);
    System.out.println(tm.isWheel);
    System.out.println(tm.isLen);
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
