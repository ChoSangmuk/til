import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J2839 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int input = Integer.parseInt(br.readLine());
    int a = input / 5;
    int b = input % 5;
    if (b == 0) System.out.println(a);
    else if (b == 1) {
      if (a >= 1) System.out.println(a + 1);
      else System.out.println(-1);
    } else if (b == 2) {
      if (a < 2) System.out.println(-1);
      else System.out.println(a + 2);
    } else if (b == 3) System.out.println(a + 1);
    else if (b == 4) {
      if (a == 0) System.out.println(-1);
      else System.out.println(a + 2);
    }
  }
}