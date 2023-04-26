import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J9498 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int input = Integer.parseInt(br.readLine());
    System.out.println(input >= 90 ? 'A' : input >= 80 ? 'B' : input >= 70 ? 'C' : input >= 60 ? 'D' : 'F');
  }
}