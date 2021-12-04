import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class J2775 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] table = new int[15][15];
    for (int i = 0; i < 15; i++) {
      int[] temp = new int[15];
      Arrays.fill(temp, 0);
      table[i] = temp.clone();
    }

    for (int j = 0; j < 15; j++) {
      table[j][0] = 1;
      table[0][j] = j + 1;
    }
    for (int k = 1; k < 15; k++) {
      for (int j = 1; j < 15; j++) {
        table[k][j] = table[k - 1][j] + table[k][j - 1];
      }
    }
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int k = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      System.out.println(table[k][n - 1]);
    }
  }
}