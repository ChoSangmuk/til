import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J9461 {
  static Long[] DP = new Long[101];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    DP[0] = (long) 0;
    DP[1] = (long) 1;
    DP[2] = (long) 1;
    DP[3] = (long) 1;
    DP[4] = (long) 2;
    DP[5] = (long) 2;

    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++)
      System.out.println(solution(Integer.parseInt(br.readLine())));
  }

  private static Long solution(int N) {
    if (DP[N] == null)
      DP[N] = solution(N - 1) + solution(N - 5);
    return DP[N];
  }
}