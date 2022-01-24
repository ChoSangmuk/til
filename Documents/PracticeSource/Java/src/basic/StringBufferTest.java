package basic;

import java.lang.StringBuffer;

public class StringBufferTest {
  public static void main(String[] args) {

    System.out.println("StringBuffer");
    StringBuffer sb = new StringBuffer();
    sb.append("aaaa");
    sb.append("aaaa");
    sb.append("aaaa");
    sb.append("aaaa");
    sb.append("aaaa");
    sb.append("aaaa");
    System.out.println(sb);

    System.out.println("\nStringBuilder");
    StringBuilder sb2 = new StringBuilder("");
    sb2.append("bbbb");
    sb2.append("bbbb");
    sb2.append("bbbb");
    sb2.append("bbbb");
    sb2.append("bbbb");
    sb2.append("bbbb");
    System.out.println(sb2.toString());

    /* time */
    System.out.print("\nString + String ");
    printRunTime1(); // +
    System.out.print("\nString concat ");
    printRunTime2(); // concat
    System.out.print("\nStringBuffer ");
    printRunTime3(); // StringBuffer
    System.out.print("\nStringBuilder ");
    printRunTime4(); // StringBuilder
  }

  public static void printRunTime1() {
    long startTime = System.currentTimeMillis();
    String s = "";
    for (int i = 0; i < 100000; i++) {
      s = s + "ssss";
    }
    System.out.println(System.currentTimeMillis() - startTime);
  }

  public static void printRunTime2() {
    long startTime = System.currentTimeMillis();
    String s = "";
    for (int i = 0; i < 100000; i++) {
      s = s.concat("ssss");
    }
    System.out.println(System.currentTimeMillis() - startTime);
  }

  public static void printRunTime3() {
    long startTime = System.currentTimeMillis();
    StringBuffer s = new StringBuffer();
    for (int i = 0; i < 100000; i++) {
      s.append("ssss");
    }
    System.out.println(System.currentTimeMillis() - startTime);
  }

  public static void printRunTime4() {
    long startTime = System.currentTimeMillis();
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < 100000; i++) {
      s.append("ssss");
    }
    System.out.println(System.currentTimeMillis() - startTime);
  }
}