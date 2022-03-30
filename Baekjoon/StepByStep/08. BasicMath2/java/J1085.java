import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class J1085 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
    int x = input[2] - input[0] < input[0] ? input[2] - input[0] : input[0];
    int y = input[3] - input[1] < input[1] ? input[3] - input[1] : input[1];
    System.out.println(x < y ? x : y);
  }
}