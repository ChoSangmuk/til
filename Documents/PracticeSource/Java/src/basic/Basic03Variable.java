package basic;

public class Basic03Variable {
  // 속성, 전역변수, 멤버변수(멤버필드)

  // static int globalInt = 10;
  int globalInt = 100;
  int testInt = 1;
  char globalChar = 'A';
  String testString = "global@email.com";

  public static void main(String[] args) {
    // System.out.println(globalInt); // Cannot make a static reference to the
    // non-static field globalInt
    Basic03Variable variable = new Basic03Variable();
    System.out.println(variable.globalInt);

    // 지역변수, 로컬변수, local variable
    int testInt = 10;
    System.out.println(testInt);
    System.out.println(variable.testInt);
    testInt = 20;
    System.out.println(testInt);
    System.out.println(variable.testInt);
    variable.testInt = 2;
    System.out.println(testInt);
    System.out.println(variable.testInt);

    String testString = "local@email.com";
    System.out.println(testString);

    // long localLong = 4444444444444444444L;
    // char intLocalChar = 33;
    // char korLocalChar = '가';
    // short localShort = 6666;
    // byte localByte = 127;
    // double localDouble = 3.14;
    // float localFloat = 3.14f;
    // boolean localBoolean = false;
  }
}
