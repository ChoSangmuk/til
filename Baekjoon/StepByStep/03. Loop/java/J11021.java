import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class J11021 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int input = Integer.parseInt(br.readLine());
    for (int i = 0; i < input; i++) {
      String[] inputs = br.readLine().split(" ");
      bw.write("Case #" + (i + 1) + ": " + (Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1])) + "\n");
    }
    bw.flush();
  }
}