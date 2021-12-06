import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J1018 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int min = 65;
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);

    String[] data = new String[N];
    for (int i = 0; i < N; i++) data[i] = br.readLine();
    for (int x = 0; x <= N - 8; x++) {
      for (int y = 0; y <= M - 8; y++) {
        String tempStr = "";
        for (int i = x; i < x + 8; i++) tempStr = tempStr.concat(data[i].substring(y, y + 8));
        int temp = solution(tempStr);
        if (min > temp) min = temp;
      }
    }
    System.out.println(min);
  }

  public static int solution(String board) {
    int A_count = 0;
    int B_count = 0;
    String temp_A = "WBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBW";
    String temp_B = "BWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWB";
    for (int i = 0; i < 64; i++) {
      if (temp_A.charAt(i) != board.charAt(i)) A_count++;
      if (temp_B.charAt(i) != board.charAt(i)) B_count++;
    }
    return A_count < B_count ? A_count : B_count;
  }
}