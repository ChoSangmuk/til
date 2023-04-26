import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J11654 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();
    System.out.println((int) input.charAt(0));
  }
}