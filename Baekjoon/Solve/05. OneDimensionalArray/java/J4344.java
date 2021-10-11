import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J4344 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int input = Integer.parseInt(br.readLine());
    for (int i = 0; i < input; i++) {
      String[] inputs = br.readLine().split(" ");
      int count = Integer.parseInt(inputs[0]);
      int sum = 0;
      int upavg = 0;

      for (int j = 1; j <= count; j++) sum += Integer.parseInt(inputs[j]);
      double avg = (double) sum / count;
      for (int j = 1; j <= count; j++) upavg = Integer.parseInt(inputs[j]) > avg ? upavg + 1 : upavg;
      
      System.out.println(String.format("%.3f", (((double) upavg / count) * 100)) + "%");
    }
  }
}