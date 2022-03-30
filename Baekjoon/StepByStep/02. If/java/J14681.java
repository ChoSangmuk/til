import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J14681 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int X = Integer.parseInt(br.readLine());
    int Y = Integer.parseInt(br.readLine());
    System.out.println(X > 0 && Y > 0 ? 1 : X > 0 && Y < 0 ? 4 : X < 0 && Y > 0 ? 2 : 3);
  }
}