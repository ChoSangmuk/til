import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class J4153 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String input = br.readLine();
      if (input.equals("0 0 0")) break;
      int[] temp = Arrays.asList(input.split(" ")).stream().mapToInt(Integer::parseInt).toArray();

      int A = (int) Math.pow(temp[0], 2);
      int B = (int) Math.pow(temp[1], 2);
      int C = (int) Math.pow(temp[2], 2);

      if (A + B == C || A + C == B || B + C == A) System.out.println("right");
      else System.out.println("wrong");
    }
  }
}