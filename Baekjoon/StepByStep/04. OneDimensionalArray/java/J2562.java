import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class J2562 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int max = 0;
    int index = 0;
    int maxindex = 0;
    String input;
    while ((input = br.readLine()) != null) {
      maxindex = max < Integer.parseInt(input) ? index : maxindex;
      max = max < Integer.parseInt(input) ? Integer.parseInt(input) : max;
      index++;
    }
    bw.write(max + "\n" + (maxindex + 1));
    bw.flush();
  }
}