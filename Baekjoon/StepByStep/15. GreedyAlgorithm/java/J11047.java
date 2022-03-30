import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class J11047 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] N = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
    int[] input = new int[N[0]];
    for (int i = 0; i < N[0]; i++) input[i] = Integer.parseInt(br.readLine());

    System.out.println(solution(input, N[1]));
  }

  public static int solution(int[] input, int target) {
    int result = 0;
    int targetCopy = target;
    for (int i = input.length - 1; i >= 0; i--) {
      int temp = targetCopy / input[i];
      if (temp >= 1) {
        targetCopy -= (temp * input[i]);
        result += temp;
      }
    }
    return result;
  }
}