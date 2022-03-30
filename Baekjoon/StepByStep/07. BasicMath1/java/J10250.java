import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class J10250 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int[] input = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

      int a = input[2] % input[0];
      int b = (int) Math.floor(input[2] / input[0]) + 1;
      if (a == 0) {
        a = input[0];
        b -= 1;
      }
      System.out.println((a * 100) + b);
    }
  }
}