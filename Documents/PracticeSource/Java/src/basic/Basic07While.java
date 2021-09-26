package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Basic07While {
  // 반복문 : while, do ... while
  public static void main(String[] args) throws IOException {
    System.out.println("while");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("\nA ");
    int i = 0;
    while (i < 10)
      System.out.print(i++);

    System.out.print("\nB ");
    i = 0;
    do
      System.out.print(i++);
    while (i < 10);

    System.out.print("\nC, exit(x)...\n");
    String x = "";
    while (!x.equals("x"))
      x = br.readLine();
    System.out.println("End");
  }
}
