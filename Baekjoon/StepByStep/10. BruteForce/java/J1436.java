import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J1436 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(br.readLine());
    int result = 665;
    while (input != 0) {
      if ((String.valueOf(result)).indexOf("666") != -1) input--;
      result++;
    }
    System.out.println(result - 1);
  }
}