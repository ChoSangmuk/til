import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.IOException;

public class J2577 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int result = 1;
    for (int i = 0; i < 3; i++) result *= Integer.parseInt(br.readLine());
    int resultLength = (result + "").length();

    int[] outputs = new int[10];
    Arrays.fill(outputs, 0);
    for (int i = 0; i < resultLength; i++) {
      outputs[result % 10]++;
      result /= 10;
    }

    for (int output : outputs) bw.write(output + "\n");
    bw.flush();
  }
}