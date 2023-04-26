import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J2908 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] reversedInput = new StringBuffer(br.readLine()).reverse().toString().split(" ");
    System.out.println(Integer.parseInt(reversedInput[0]) > Integer.parseInt(reversedInput[1])
      ? Integer.parseInt(reversedInput[0]) : Integer.parseInt(reversedInput[1]));
  }
}