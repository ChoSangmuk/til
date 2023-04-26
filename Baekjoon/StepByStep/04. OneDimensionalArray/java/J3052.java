import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.IOException;

public class J3052 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int result = 0;
    int[] inputs = new int[42];
    Arrays.fill(inputs, 0);

    for (int i = 0; i < 10; i++) {
      int temp = Integer.parseInt(br.readLine());
      inputs[temp % 42] += 1;
    }
    for (int input : inputs)
      result = input == 0 ? result : result + 1;

    bw.write(result + "\n");
    bw.flush();
  }
}