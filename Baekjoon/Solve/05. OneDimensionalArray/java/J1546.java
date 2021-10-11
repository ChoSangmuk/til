import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J1546 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int max = 0;
    int sum = 0;
    br.readLine();
    String[] inputs = br.readLine().split(" ");
    for (String input : inputs) {
      sum += Integer.parseInt(input);
      max = max < Integer.parseInt(input) ? Integer.parseInt(input) : max;
    }
    System.out.println((double) (sum * 100) / (inputs.length * max));
  }
}