import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J2798 {
  static int N = 0;
  static int M = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);

    System.out.println(solution(br.readLine().split(" ")));
  }

  public static int solution(String[] input) {
    int answer = 0;
    for (var f = 0; f < N - 2; f++) {
      for (var s = f + 1; s < N - 1; s++) {
        for (var t = s + 1; t < N; t++) {
          var temp = Integer.parseInt(input[f]) + Integer.parseInt(input[s]) + Integer.parseInt(input[t]);
          if (temp == M) return M;
          else if (temp < M && temp > answer) answer = temp;
        }
      }
    }
    return answer;
  }
}