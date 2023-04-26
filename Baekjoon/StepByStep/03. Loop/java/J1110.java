import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J1110 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine().trim();
    String copy = input + "";
    int result = 0;
    do {
      int tempSum = 0;
      for (String temp : copy.split(""))
        tempSum += !temp.equals("") ? Integer.parseInt(temp) : 0;
      copy = (Integer.parseInt(copy) % 10) + "" + (tempSum % 10) + "";
      result++;
    } while (Integer.parseInt(input) != Integer.parseInt(copy));
    System.out.println(result);
  }
}