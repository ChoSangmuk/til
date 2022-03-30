import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J2292 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int input = Integer.parseInt(br.readLine());
    int a = (int) Math.floor((input - 1) / 6);
    int b = (input - 1) % 6;
    if (b > 0) a++;
    int sum = 0;
    for (int i = 0; i <= a; i++) {
      sum += i;
      if (sum >= a) {
        System.out.println(i + 1);
        break;
      }
    }
  }
}