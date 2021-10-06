import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class J2439 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] NX = br.readLine().split(" ");
    String[] inputs = br.readLine().split(" ");
    String result = "";
    for (String input : inputs)
      result += (Integer.parseInt(input) < Integer.parseInt(NX[1]) ? input + " " : "");
    result.trim();
    bw.write(result);
    bw.flush();
  }
}