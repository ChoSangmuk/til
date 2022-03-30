import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J11720 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split("");
    int result = 0;
    for (int i = 0; i < N; i++) result += Integer.parseInt(input[i]);
    System.out.println(result);
  }
}