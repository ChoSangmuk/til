import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class J2438 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int input = Integer.parseInt(br.readLine());
    for (int i = 0; i < input; i++) {
      for (int j = 0; j <= i; j++)
        bw.write("*");
      bw.write("\n");
    }
    bw.flush();
  }
}