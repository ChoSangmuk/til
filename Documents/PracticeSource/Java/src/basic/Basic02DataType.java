package basic;

public class Basic02DataType {
  // 데이터 타입과 범위
  public static void main(String[] args) {
    // 문자 Char(character)
    System.out.println('y');
    System.out.println((int) Character.MIN_VALUE + "~" + (int) Character.MAX_VALUE + "\n");

    // 문자열 String
    System.out.println("y");
    System.out.println();

    // 정수 Int(integer),byte,short,char,long(L)
    System.out.println(1);
    System.out.println(Byte.MIN_VALUE + "~" + Byte.MAX_VALUE);
    System.out.println(Short.MIN_VALUE + "~" + Short.MAX_VALUE);
    System.out.println(Integer.MIN_VALUE + "~" + Integer.MAX_VALUE);
    System.out.println(Long.MIN_VALUE + "~" + Long.MAX_VALUE + "\n");

    // 실수 Double, float(f)
    System.out.println(0.14);
    System.out.println(0.14f);
    System.out.println(Float.MIN_VALUE + "~" + Float.MAX_VALUE);
    System.out.println(Double.MIN_VALUE + "~" + Double.MAX_VALUE + "\n");

    // 논리 Boolean
    System.out.println(Boolean.FALSE + ", " + Boolean.TRUE);
  }
}
