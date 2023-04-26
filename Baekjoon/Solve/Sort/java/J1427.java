import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.io.IOException;

public class J1427 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split("");
    Arrays.sort(input, Comparator.reverseOrder());

    for (String value : input) System.out.print(value);
    System.out.println();
  }
}