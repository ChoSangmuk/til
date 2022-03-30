import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class J1712 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

    int result = input[2] - input[1];
    if (result <= 0) result = -1;
    else result = (int) (Math.floor(input[0] / result) + 1);
    System.out.println(result);
  }
}