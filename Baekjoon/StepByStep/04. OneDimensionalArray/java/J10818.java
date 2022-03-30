import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class J10818 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int input = Integer.parseInt(br.readLine());
    String[] inputs = br.readLine().split(" ");
    int max = Integer.parseInt(inputs[0]), min = Integer.parseInt(inputs[0]);
    for (int i = 0; i < input; i++) {
      min = min > Integer.parseInt(inputs[i]) ? Integer.parseInt(inputs[i]) : min;
      max = max < Integer.parseInt(inputs[i]) ? Integer.parseInt(inputs[i]) : max;
    }
    bw.write(min + " " + max);
    bw.flush();
  }
}