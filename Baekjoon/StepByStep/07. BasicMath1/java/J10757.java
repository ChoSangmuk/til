import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class J10757 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    ArrayList<String> A = new ArrayList<String>();
    A.addAll(Arrays.asList(input[0].split("")));
    ArrayList<String> B = new ArrayList<String>();
    B.addAll(Arrays.asList(input[1].split("")));
    ArrayList<Integer> result = new ArrayList<Integer>();

    int temp = 0;
    while (true) {
      if (A.size() == 0 && B.size() == 0) break;
      String temp_a = A.size() - 1 < 0 ? "0" : A.remove(A.size() - 1);
      String temp_b = B.size() - 1 < 0 ? "0" : B.remove(B.size() - 1);

      int temp_sum = Integer.parseInt(temp_a) + Integer.parseInt(temp_b) + temp;
      if (temp_sum >= 10) temp = 1;
      else temp = 0;
      result.add(0, temp_sum % 10);
    }
    if (temp == 1) result.add(0, 1);
    System.out.println(Arrays.toString(result.toArray()).replaceAll("[^0-9]", ""));
  }
}