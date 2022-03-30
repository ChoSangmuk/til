import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class J13305 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    br.readLine();
    long[] distance = Arrays.asList(br.readLine().split(" ")).stream().mapToLong(Long::parseLong).toArray();
    long[] cost = Arrays.asList(br.readLine().split(" ")).stream().mapToLong(Long::parseLong).toArray();

    long result = 0;
    long min = cost[0];
    for (int i = 0; i < distance.length; i++) {
      if (cost[i] < min) min = cost[i];
      result += min * distance[i];
    }
    System.out.println(result);
  }
}