import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class J1011 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int[] input = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
      int result = 1;
      while (result % 2 == 1 ? Math.pow((result + 1) / 2, 2) < input[1] - input[0] : (result / 2) * ((result / 2) + 1) < input[1] - input[0]) result++;
      System.out.println(result);
    }
  }
}