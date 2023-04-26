import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class J1978 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] input = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

    int result = 0;
    for (int i = 0; i < N; i++) {
      var isPrime = true;
      for (int j = 1; j <= input[i] / 2; j++) {
        if (j == 1) continue;
        else if (input[i] % j == 0) {
          isPrime = false;
          break;
        }
      }
      if (input[i] != 1 && isPrime) result++;
    }
    System.out.println(result);
  }
}