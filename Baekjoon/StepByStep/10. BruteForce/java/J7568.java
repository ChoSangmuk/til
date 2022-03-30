import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J7568 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] input = new int[N][2];
    for (int i = 0; i < N; i++) {
      String[] temp = br.readLine().split(" ");
      input[i][0] = Integer.parseInt(temp[0]);
      input[i][1] = Integer.parseInt(temp[1]);
    }
    String result = "";
    for (int i = 0; i < N; i++) {
      int temp = 1;
      for (int j = 0; j < N; j++)
        if (input[i][0] < input[j][0] && input[i][1] < input[j][1]) temp++;
      result += temp + " ";
    }
    System.out.println(result);
  }
}