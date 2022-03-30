import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class J1541 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();
    String[] separate = input.split("[-]");

    for (int i = 0; i < separate.length; i++) {
      StringTokenizer st = new StringTokenizer(separate[i]);
      int total = 0;
      while (st.hasMoreTokens()) total += Integer.parseInt(st.nextToken("+"));
      separate[i] = total + "";
    }

    int result = Integer.parseInt(separate[0]);
    for (int i = 1; i < separate.length; i++) result -= Integer.parseInt(separate[i]);

    System.out.println(result);
  }
}
