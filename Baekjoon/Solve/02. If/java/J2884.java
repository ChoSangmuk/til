import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J2884 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] temps = br.readLine().split(" ");
    int[] inputs = new int[temps.length];
    for (int i = 0; i < temps.length; i++)
      inputs[i] = Integer.parseInt(temps[i]);
    System.out.println((inputs[1] < 45 ? inputs[0] == 0 ? 23 : inputs[0] - 1 : inputs[0]) + " "
        + (inputs[1] < 45 ? 15 + inputs[1] : inputs[1] - 45));
  }
}