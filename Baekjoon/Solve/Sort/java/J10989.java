import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class J10989 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] temp = new int[10001];
    for (int i = 0; i < N; i++) temp[Integer.parseInt(br.readLine())]++;
    for (int i = 0; i < temp.length; i++) {
      if (temp[i] != 0) {
        for (int k = 0; k < temp[i]; k++) bufferedWriter.append(Integer.toString(i) + "\n");
      }
    }
    bufferedWriter.flush();
  }
}