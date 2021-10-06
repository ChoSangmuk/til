import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J10951 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input;
    while ((input = br.readLine()) != null) {
      String[] temp = input.split(" ");
      System.out.println(Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]));
    }
  }
}