import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J10950 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int input = Integer.parseInt(br.readLine());
    for (int i = 0; i < input; i++) {
      String[] inputs = br.readLine().split(" ");
      System.out.println(Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1]));
    }
  }
}