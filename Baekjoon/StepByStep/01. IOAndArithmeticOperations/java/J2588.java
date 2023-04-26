import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J2588 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    int temp = b;

    System.out.println(a * (temp % 10));
    temp /= 10;
    System.out.println(a * (temp % 10));
    temp /= 10;
    System.out.println(a * (temp % 10));
    System.out.println(a * b);
  }
}