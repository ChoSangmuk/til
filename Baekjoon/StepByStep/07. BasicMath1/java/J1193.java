import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J1193 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int input = Integer.parseInt(br.readLine());
    int sum = 0;
    int flag1 = 0;
    for (int i = 1; i <= input; i++) {
      sum += i;
      if (sum >= input) {
        flag1 = i;
        break;
      }
    }
    if (flag1 % 2 == 1) System.out.println((sum - input + 1) + "/" + (input - sum + flag1));
    else System.out.println((input - sum + flag1) + "/" + (sum - input + 1));
  }
}