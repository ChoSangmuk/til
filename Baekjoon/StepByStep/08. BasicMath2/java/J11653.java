import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J11653 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(br.readLine());
    while (input != 1) {
      for (int i = 2; i <= input; i++) {
        if (input % i == 0) {
          System.out.println(i);
          input /= i;
          break;
        }
      }
    }
  }
}