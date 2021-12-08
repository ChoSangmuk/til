import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J2581 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int M = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());

    int result = 0;
    int isFirst = 0;
    for (int i = M; i <= N; i++) {
      if (isPrime(i)) {
        result += i;
        if (isFirst == 0) isFirst = i;
      }
    }
    if (isFirst == 0) System.out.println(-1);
    else {
      System.out.println(result);
      System.out.println(isFirst);
    }
  }

  public static boolean isPrime(int inputNumber) {
    if (inputNumber == 1) return false;
    for (var i = 2; i < inputNumber; i++) {
      if (inputNumber % i == 0) return false;
    }
    return true;
  }
}