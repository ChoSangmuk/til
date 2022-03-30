import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J2739 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int input = Integer.parseInt(br.readLine());
    for (int i = 1; i <= 9; i++)
      System.out.println(input + " * " + i + " = " + input * i);
  }
}