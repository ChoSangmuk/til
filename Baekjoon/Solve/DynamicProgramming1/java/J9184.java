import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class J9184 {
  private static int[][][] dp = new int[21][21][21];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int a = 0; a <= 20; a++) {
      for (int b = 0; b <= 20; b++) {
        for (int c = 0; c <= 20; c++) {
          int temp_a = a - 1 <= 0 ? 0 : a - 1, temp_b = b - 1 <= 0 ? 0 : b - 1, temp_c = c - 1 <= 0 ? 0 : c - 1;
          if (a <= 0 || b <= 0 || c <= 0)
            dp[a][b][c] = 1;
          else if (a < b && b < c)
            dp[a][b][c] = dp[a][b][temp_c] + dp[a][temp_b][temp_c] - dp[a][temp_b][c];
          else
            dp[a][b][c] = dp[temp_a][b][c] + dp[temp_a][temp_b][c] + dp[temp_a][b][temp_c] - dp[temp_a][temp_b][temp_c];
        }
      }
    }

    while (true) {
      String input = br.readLine();
      if (input.equals("-1 -1 -1"))
        break;
      int[] temp = Arrays.asList(input.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
      String answer = "w(" + temp[0] + ", " + temp[1] + ", " + temp[2] + ") = ";
      if (temp[0] <= 0 || temp[1] <= 0 || temp[2] <= 0)
        System.out.println(answer + dp[0][0][0]);
      else if (temp[0] > 20 || temp[1] > 20 || temp[2] > 20)
        System.out.println(answer + dp[20][20][20]);
      else
        System.out.println(answer + dp[temp[0]][temp[1]][temp[2]]);
    }
  }
}