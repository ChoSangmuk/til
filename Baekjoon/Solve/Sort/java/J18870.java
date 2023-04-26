import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

public class J18870 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] input = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
    int[] copy = input.clone();
    Arrays.sort(copy);

    Map<Integer, Integer> map = new HashMap<>();
    int i = 0;
    for (int value : copy) if (!map.containsKey(value)) map.put(value, i++);

    StringBuilder result = new StringBuilder();
    for (int value : input) result.append(map.get(value) + " ");
    System.out.println(result.toString());
  }
}