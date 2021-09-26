package basic;

import java.util.Random;

public class Basic09Random {
  // Random 패키지 사용해 보기
  public static void main(String[] args) {
    // Random r = new Random();
    // System.out.println("Random r.nextInt(10) =>" + r.nextInt(10));
    // 혹은
    // double d = Math.random() * 10;
    // System.out.println("Math d:" + (int) d);

    String[] chars = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" };
    Random r = new Random();
    for (int i = 0; i < chars.length; i++) {
      int temp = r.nextInt(15);
      System.out.println("Random chars[" + temp + "]:" + chars[temp]);
      if (i == chars.length - 1) {
        System.out.println("============");
        System.out.println("Last:" + chars[temp]);
        System.out.println("============");
      }
    }
  }
}
