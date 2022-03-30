import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J10952 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input;
    while (!(input = br.readLine()).equals("0 0")) {
      String[] temp = input.split(" ");
      System.out.println(Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]));
    }
  }
}