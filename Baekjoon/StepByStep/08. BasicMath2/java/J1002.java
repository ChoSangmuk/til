import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class J1002 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    for (int k = 0; k < N; k++) {
      int[] input = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
      System.out.println(solution(input));
    }
  }

  public static int solution(int[] setting) {
    double distance = Math.sqrt(Math.pow(setting[0] - setting[3], 2) + Math.pow(setting[1] - setting[4], 2));
    if (setting[0] == setting[3] && setting[1] == setting[4] && setting[2] == setting[5])
      return -1;
    else if (distance == setting[2] + setting[5] || setting[2] == setting[5] + distance || setting[5] == setting[2] + distance)
      return 1;
    else if (distance < setting[2] + setting[5] && setting[2] < setting[5] + distance && setting[5] < setting[2] + distance)
      return 2;
    return 0;
  }
}