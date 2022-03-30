import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J10872 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int input = Integer.parseInt(br.readLine());
    System.out.println(solution(input));
  }

  public static int solution(int input) {
    if (input <= 1)
      return 1;
    return solution(input - 1) * input;
  }
}