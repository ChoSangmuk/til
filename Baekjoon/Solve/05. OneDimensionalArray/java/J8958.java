import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J8958 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int input = Integer.parseInt(br.readLine());
    for (int i = 0; i < input; i++) {
      int sum = 0;
      String[] inputs = br.readLine().split("X");
      for (String temp : inputs) sum += ((temp.length() * (temp.length() + 1)) / 2);
      System.out.println(sum);
    }
  }
}