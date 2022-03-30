import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J11729 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(br.readLine());
    int temp = 1;
    for (int i = 0; i < input - 1; i++)
      temp = temp * 2 + 1;
    System.out.println(temp + "\n" + solution(input, 1, 2, 3));
  }

  public static String solution(int number, int start, int middle, int target) {
    if (number == 1)
      return start + " " + target + "\n";
    return solution(number - 1, start, target, middle) + start + " " + target + "\n"
        + solution(number - 1, middle, start, target);
  }
}