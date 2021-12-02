import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J10809 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();
    String result = "";
    for (int i = 97; i <= 122; i++) result += input.indexOf((((char) i) + "").toString()) + " ";
    System.out.println(result);
  }
}