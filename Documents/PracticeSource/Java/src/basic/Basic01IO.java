package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Basic01IO {
  // 기본 입, 출력 방식
  public static void main(String[] args) throws IOException {
    System.out.print("Hello, World! 1");
    System.out.println("Hello, World! 2");
    System.out.print("Hello, World! 3");
    System.out.printf("%s", "Hello, World! 4\n");

    InputStream is = System.in;
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("input String:");
    String input = br.readLine();
    System.out.println(input);

    System.out.println("input Int:");
    input = br.readLine();
    System.out.println(Integer.parseInt(input));
  }
}
