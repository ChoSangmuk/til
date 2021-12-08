import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J3053 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(br.readLine());
    System.out.println(input * input * Math.PI);
    System.out.println(input * input * 2);
  }
}