import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J2231 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(solution(Integer.parseInt(br.readLine())));
  }

  public static int solution(int input) {
    for (int i = 1; i < input; i++) {
      int sum = i;
      int temp = i;
      while (temp != 0) {
        sum += temp % 10;
        temp /= 10;
      }
      if (sum == input) return i;
    }
    return 0;
  }
}