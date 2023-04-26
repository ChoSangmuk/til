import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J5622 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(problem(br.readLine()));
  }

  public static int problem(String input) {
    int answer = input.length();
    for (int i = 0; i < input.length(); i++) {
      var temp = (int) input.charAt(i) - 65; // A=0, B=1, ...
      if (temp < 18) answer += ((temp / 3) + 2);
      else if (temp == 18) answer += 7;
      else if (temp < 22) answer += 8;
      else answer += 9;
    }
    return answer;
  }
}