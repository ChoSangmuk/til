import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class J11399 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] input = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

    int result = 0;
    Arrays.sort(input);
    for (int i = 0; i < N; i++) result += (input.length - i) * input[i];
    System.out.println(result);
  }
}