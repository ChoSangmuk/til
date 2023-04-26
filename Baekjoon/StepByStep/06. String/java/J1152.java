import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J1152 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int count = 0;
    for (int i = 0; i < input.length; i++) if (input[i].length() > 0) count++;
    System.out.println(count);
  }
}