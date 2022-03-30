import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J2675 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      String result = "";
      for (int j = 0; j < input[1].length(); j++) {
        for (int k = 0; k < Integer.parseInt(input[0]); k++)
          result += input[1].charAt(j);
      }
      System.out.println(result);
    }
  }
}