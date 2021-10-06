import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J8393 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int input = Integer.parseInt(br.readLine());
    int result = 0;
    for (int i = 1; i <= input; i++) result += i;
    System.out.println(result);
  }
}