import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J1008 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str = br.readLine().split(" ");
    Double a = Double.parseDouble(str[0]);
    Double b = Double.parseDouble(str[1]);

    System.out.println(a / b);
  }
}