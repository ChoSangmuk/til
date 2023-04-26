import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class J2439 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int input = Integer.parseInt(br.readLine());
    for (int i = 0; i < input; i++) {
      for (int j = 0; j < input; j++)
        bw.write(j < (input - 1 - i) ? " " : "*");
      bw.write("\n");
    }
    bw.flush();
  }
}