import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;;

public class J2941 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();
    System.out.println(input
        .replaceAll("dz=", "!")
        .replace("z=", "!")
        .replace("s=", "!")
        .replace("d-", "!")
        .replace("c=", "!")
        .replace("c-", "!")
        .replace("lj", "!")
        .replace("nj", "!")
        .length());
  }
}