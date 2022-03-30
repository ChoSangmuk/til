import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class J1929 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
    boolean[] result = solution(input[1]);
    int i = 0;
    for (boolean v : result) {
      if (i >= input[0] && i <= input[1] && v) System.out.println(i);
      i++;
    }
  }

  public static boolean[] solution(int n) {
    boolean[] answer = new boolean[n + 1];
    Arrays.fill(answer, true);
    answer[0] = false;
    answer[1] = false;
    int pointer = 2;
    while (pointer != n) {
      if (answer[pointer] == true)
        for (int i = 2; pointer * i <= n; i++) answer[pointer * i] = false;
      pointer++;
    }
    return answer;
  }
}