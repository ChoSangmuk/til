import java.io.IOException;
import java.util.Scanner;

public class J1904 {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    int[] dp = { 1, 2 };
    for (int i = 2; i <= t; i++) {
      int temp = dp[0];
      dp[0] = dp[1];
      dp[1] = (temp + dp[1]) % 15746;
    }
    System.out.println(dp[0]);
  }
}
